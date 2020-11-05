package com.example.backbuttondestory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long back_btn_Time = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();
        long gapTime = currentTime - back_btn_Time;

        if (0<gapTime && 2000>gapTime){
            super.onBackPressed();
        }
        else {
            back_btn_Time = currentTime;
            Toast.makeText(getApplicationContext(),"한번 더 누르면 종료합니다.",Toast.LENGTH_SHORT).show();
        }

    }
}