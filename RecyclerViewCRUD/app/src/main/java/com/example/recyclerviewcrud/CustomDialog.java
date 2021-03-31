package com.example.recyclerviewcrud;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.google.android.material.badge.BadgeUtils;

public class CustomDialog extends Dialog {
    private EditText name,age;
    private Button confirm,cancel;
    Callback callback;
    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cu_layout);
        name = findViewById(R.id.et_name);
        age = findViewById(R.id.et_age);
        confirm = findViewById(R.id.btn_confirm);
        cancel = findViewById(R.id.btn_cancel);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClick(name.getText().toString(),Integer.parseInt(age.getText().toString()));
                dismiss();
            }
        });
    }
    public void setCallback(Callback callback){
        this.callback = callback;

    }
    public void setOnClick(String name,int age){
        callback.setOnClick(name,age);
    }
}
