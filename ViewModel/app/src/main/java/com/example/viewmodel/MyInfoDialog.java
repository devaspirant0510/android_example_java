package com.example.viewmodel;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.viewmodel.databinding.DialogMyInfoBinding;

public class MyInfoDialog extends Dialog {
    private MyInfo myInfo;
    private DialogMyInfoBinding mb;
    private OnSubmitClickListener listener = null;

    public interface OnSubmitClickListener{
        void setOnClick(MyInfo myInfo);
    }
    public void setOnSubmitClickListener(OnSubmitClickListener listener){
        this.listener = listener;

    }
    public void setOnSendData(MyInfo myInfo){
        listener.setOnClick(myInfo);
    }

    public MyInfoDialog(@NonNull Context context,MyInfo myInfo) {
        super(context);
        this.myInfo = myInfo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mb = DialogMyInfoBinding.inflate(getLayoutInflater());
        setContentView(mb.getRoot());
        getData();
        init();
    }

    private void init() {
        mb.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnSendData(new MyInfo(mb.etName.getText().toString(),Integer.parseInt(mb.etAge.getText().toString()),
                        mb.etLanguage.getText().toString(),mb.etFramework.getText().toString()));
                dismiss();
            }
        });
    }

    private void getData() {
        mb.setMyInfo(this.myInfo);
    }
}

