package com.example.activitycommunicationinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements DataSender.MySender{
    CallbackInter callbackInter;
    CallbackSender callbackSender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.page,new F1()).commit();
        DataSender sender = new DataSender(this);
        sender.setMySender(this);
        sender.sendMessageMethod();

    }
    public void setCallbackInter(CallbackInter callbackInter){
        this.callbackInter = callbackInter;
    }
    public void callbackMethod(String str1, String str2){
        callbackInter.callBackMethod(str1,str2);
    }


    @Override
    public void sendMessage(String str1) {
        Log.e("MainActivity",str1);

    }
}