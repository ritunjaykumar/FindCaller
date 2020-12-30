package com.softgyan.findcaller.mail;

public class MailMessage {
    private final String to;
    private final String subject;
    private final String message;

    public MailMessage(String to, String subject, String message) {
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }


}
