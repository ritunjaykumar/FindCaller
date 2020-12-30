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


public class ForgotPasswordFragment extends Fragment {

    private TextView mGotoRegisterFragment;
    public ForgotPasswordFragment() {
        // Required empty public constructor
    }

    public static ForgotPasswordFragment getInstance() {
        ForgotPasswordFragment fragment = new ForgotPasswordFragment();
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
        View view = inflater.inflate(R.layout.fragment_forgot_password, container, false);
        mGotoRegisterFragment = view.findViewById(R.id.tv_go_to_log_in);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mGotoRegisterFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getActivity() instanceof RegisterAccountActivity){
                    ((RegisterAccountActivity) getActivity()).setFragment(SignInFragment.getInstance(),"SignIn");
                }
            }
        });
    }
}
