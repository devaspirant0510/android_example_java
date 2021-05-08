package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mb = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mb.getRoot());


        init();
    }

    private void init() {
        mb.setTextData(new TextData("이야!!~~","이것이 바로","데이타 바인딩이구나ㅋㅋㅋ"));
    }
}