package com.example.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.viewmodel.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mb;
    private static final String TAG = "MainActivity";
    private MyInfoViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mb = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mb.getRoot());
        model = new ViewModelProvider(this).get(MyInfoViewModel.class);
        model.mLiveData.observe(this, new Observer<MyInfo>() {
            @Override
            public void onChanged(MyInfo myInfo) {
                Log.e(TAG, "onChanged: "+myInfo.getFrameWork() );
                mb.setMyInfo(myInfo);
            }
        });
        if(model.mLiveData.getValue()==null){
            setData();
        }
        init();
    }

    private void init() {
        mb.setMyInfo(model.mLiveData.getValue());
        mb.btnUpdateDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyInfoDialog dialog = new MyInfoDialog(MainActivity.this,model.mLiveData.getValue());
                dialog.setOnSubmitClickListener(new MyInfoDialog.OnSubmitClickListener() {
                    @Override
                    public void setOnClick(MyInfo myInfo) {
                        model.mLiveData.setValue(myInfo);
                    }
                });
                dialog.show();

            }
        });
    }

    private void setData() {
        MyInfo data = new MyInfo("이승호",20,"Python,JAVA,JavaScript,Korean","Android,PyTorch,Node js,Flask");
        model.mLiveData.setValue(data);
    }
}