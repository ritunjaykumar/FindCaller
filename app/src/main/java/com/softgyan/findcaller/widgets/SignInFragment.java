package com.softgyan.findcaller.widgets;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softgyan.findcaller.R;

public class SignInFragment extends Fragment {
    private TextView mForgotPassword;
    private TextView mDontAccount;

    public SignInFragment() {
        // Required empty public constructor
    }

    public static SignInFragment getInstance() {
        SignInFragment fragment = new SignInFragment();
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
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        mForgotPassword = view.findViewById(R.id.tv_forgot_password);
        mDontAccount = view.findViewById(R.id.tv_dont_account);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getActivity() instanceof RegisterAccountActivity){
                    ((RegisterAccountActivity) getActivity()).setFragment(ForgotPasswordFragment.getInstance(),"Forgot Password");
                }
            }
        });
        mDontAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getActivity() instanceof RegisterAccountActivity){
                    ((RegisterAccountActivity) getActivity()).setFragment(RegisterAccountFragment.getInstance(),"Register Account");
                }
            }
        });
    }
}
