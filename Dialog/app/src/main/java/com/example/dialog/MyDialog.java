package com.example.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class MyDialog extends Dialog {
    private Button okBtn, cancelBtn;
    private EditText dialogEt;
    private DialogCallback callback;

    public MyDialog(Context context) {
        super(context);
    }

    public void setDialogCallback(DialogCallback callback) {
        this.callback = callback;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_dialog);
        init();


    }

    private void init() {
        okBtn = findViewById(R.id.btn_dialog_confirm);
        cancelBtn = findViewById(R.id.btn_dialog_cancel);
        dialogEt = findViewById(R.id.et_my_dialog);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.setOnClickDialog(dialogEt.getText().toString());
                dismiss();


            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}

