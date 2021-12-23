package com.example.activitycommunicationinterface;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class F1 extends Fragment implements CallbackInter{
    View root;
    MainActivity activity;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (MainActivity)getActivity();
        activity.setCallbackInter(this);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.f1,container,false);
        DataSender sender = new DataSender(activity);
        sender.sendData();
        return root;
    }

    @Override
    public void callBackMethod(String str1, String str2) {
        Toast.makeText(getContext(),"받아옴"+str1+" "+str2,Toast.LENGTH_SHORT).show();
        Log.e("F1","받아옴"+str1+" "+str2);
    }
}
