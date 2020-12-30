package com.softgyan.findcaller.widgets;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.softgyan.findcaller.R;

public class RegisterAccountFragment extends Fragment {
    private static final String OTP = "Get OTP";
    private static final String REGISTER = "Register Account";
    private static final String VERIFY = "Verify OTP";


    private TextView mHaveAccount;
    private LinearLayout mVerifiedAccount;
    private TextView mEmailId;
    private TextView mOtp;
    private TextView mUserName;
    private TextView mPassword;
    private Button mRegister;
    private ProgressBar progressBar;
    private TextView mErrorMessage;

    public RegisterAccountFragment() {
        // Required empty public constructor
    }


    public static RegisterAccountFragment getInstance() {
        RegisterAccountFragment fragment = new RegisterAccountFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register_account, container, false);
        mHaveAccount = view.findViewById(R.id.tv_have_account);
        mVerifiedAccount = view.findViewById(R.id.account_verify);
        mEmailId = view.findViewById(R.id.tv_email_id);
        mOtp = view.findViewById(R.id.tv_otp);
        mUserName = view.findViewById(R.id.tv_user_name);
        mPassword = view.findViewById(R.id.tv_password);
        mRegister = view.findViewById(R.id.btn_register);
        progressBar = view.findViewById(R.id.progress_bar);
        mErrorMessage = view.findViewById(R.id.tv_error_message);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getActivity() instanceof RegisterAccountActivity){
                    ((RegisterAccountActivity) getActivity()).setFragment(SignInFragment.getInstance(),"SignIn");
                }
            }
        });
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((Button)v).getText().toString().equals(OTP)){
                    //call mailSystem function
                    mRegister.setText(VERIFY);
                    mOtp.setVisibility(View.VISIBLE);
                    mVerifiedAccount.setVisibility(View.VISIBLE);
                }
                else if(((Button)v).getText().toString().equals(VERIFY)){
                    //match generated code to user inter code
                    mRegister.setText(REGISTER);
                    mUserName.setVisibility(View.VISIBLE);
                    mPassword.setVisibility(View.VISIBLE);
                }else if (((Button)v).getText().toString().equals(REGISTER)){
                    //code for authentication

                }

            }
        });
    }
}