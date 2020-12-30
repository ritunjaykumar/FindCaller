package com.softgyan.findcaller.mail;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailSystem  extends AsyncTask<Void, Void, Void> {
    private final static String EMAIL="mrhacker6162@gmail.com";
    private final static String PASSWORD = "teacher9615";
    private final static String HOST = "smtp.gmail.com";

    //basic variable
    private final String from;
    private static MailSystem mailSystem;
    private final Context mContext;
    private MailMessage mailMessage;

    private MailSystem(Context context) {
        this.from = EMAIL;
        mContext = context;
    }

    public static MailSystem getInstance(Context context) {
        if(mailSystem == null){
            mailSystem = new MailSystem(context);
        }
        return mailSystem;
    }
    public void setData(MailMessage mailMessage){
        this.mailMessage = mailMessage;
    }
//    public void sendMail(MailMessage mailMessage, OnMailSendListener onMailSendListener){
//
//        //set Properties class
//        final Properties properties = System.getProperties();
//        Log.i("tag", "properties"+properties.toString());
//        properties.put("mail.smtp.host",HOST);
//        properties.put("mail.smtp.port","465");
//        properties.put("mail.smtp.ssl.enable","true");
//        properties.put("mail.smtp.aut","true");
//
//        //step 1. get session instance
//        Log.i("tag","step 1");
//        Session session = Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(EMAIL, PASSWORD);
//            }
//        });
////        if(session == null){
////            onMailSendListener.onFailed("something is error");
////        }
//        session.setDebug(true);
//        //step 2. compose message
//        Log.i("tag","step 2");
//
//        MimeMessage mimeMessage = new MimeMessage(session);
//        try {
//        mimeMessage.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(mailMessage.getTo()));
//            mimeMessage.setSubject(mailMessage.getSubject());
//            mimeMessage.setText(mailMessage.getMessage());
//
//            //step 3. send message
//            Transport.send(mimeMessage);
//            Toast.makeText(mContext, "message sent", Toast.LENGTH_SHORT).show();
//            onMailSendListener.onSuccessful("check your mail");
//        }catch (MessagingException ex){
////            onMailSendListener.onFailed(ex.getMessage());
//            Toast.makeText(mContext, ex.toString(), Toast.LENGTH_SHORT).show();
////            Log.i("tag", ex.getMessage());
//        }
//    }

    @Override
    protected Void doInBackground(Void... voids) {
        final Properties props = System.getProperties();
//        Log.i("tag", "properties"+properties.toString());
//        properties.put("mail.smtp.host",HOST);
//        properties.put("mail.smtp.port","465");
//        properties.put("mail.smtp.ssl.enable","true");
//        properties.put("mail.smtp.aut","true");

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");


        //step 1. get session instance
        Log.i("tag","step 1");
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL, PASSWORD);
            }
        });
        session.setDebug(true);
        //step 2. compose message
        Log.i("tag","step 2");

        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(from);
            mimeMessage.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(mailMessage.getTo()));
            mimeMessage.setSubject(mailMessage.getSubject());
            mimeMessage.setText(mailMessage.getMessage());

            //step 3. send message
            Transport.send(mimeMessage);
//            Toast.makeText(mContext, "message sent", Toast.LENGTH_SHORT).show();
            Log.i("tag","message_sent");
        }catch (MessagingException ex){
            ex.printStackTrace();
            Log.i("tag","message_not_sent  "+ex.getMessage());
        }
        return null;
    }

    public interface OnMailSendListener {
        void onSuccessful(String message);
        void onFailed(String errorMessage);
    }

}
