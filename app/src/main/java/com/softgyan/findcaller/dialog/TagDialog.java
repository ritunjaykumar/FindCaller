package com.softgyan.findcaller.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.softgyan.findcaller.R;

public class TagDialog extends Dialog implements View.OnClickListener {
    private final EditText mOtherString;
    private final ImageButton mOk;
    private String tagName;

    public TagDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.tag_item_layout);
        String id_str = "tv_id_";
        for (int i = 1; i <= 9; i++) {
            int id = getContext().getResources().getIdentifier(id_str + i, "string", getContext().getPackageName());
            findViewById(id).setOnClickListener(this);
        }
        mOtherString = findViewById(R.id.et_others);
        mOk = findViewById(R.id.btn_save);
        mOk.setOnClickListener(v -> {
            if (!TextUtils.isEmpty(mOtherString.getText().toString().trim())) {
                tagName = mOtherString.getText().toString().trim();
            }else{
                Toast.makeText(context, "can't be empty!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        tagName = ((TextView) v).getText().toString();
        if (tagName.equals(getContext().getResources().getString(R.string.others))) {
            mOtherString.setVisibility(View.VISIBLE);
            mOk.setVisibility(View.VISIBLE);
        }
    }

    public String getTagName(){
        return tagName;
    }
}
