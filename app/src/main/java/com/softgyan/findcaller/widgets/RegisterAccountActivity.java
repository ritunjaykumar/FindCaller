package com.softgyan.findcaller.widgets;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.softgyan.findcaller.R;

import java.util.Objects;

public class RegisterAccountActivity extends AppCompatActivity {
    private Fragment mCurrentFragment;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_account);
        // set ToolBar
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        //call first fragment
        setFragment(SignInFragment.getInstance(), "Sign in");

    }

    public void setFragment(Fragment fragment, String title) {
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
        mCurrentFragment = fragment;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.close_animation, R.anim.start_animation);
        transaction.replace(R.id.fragment_container, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        if (mCurrentFragment instanceof SignInFragment) {
            super.onBackPressed();
        } else {
            setFragment(SignInFragment.getInstance(), "Sign in");
        }
    }


}