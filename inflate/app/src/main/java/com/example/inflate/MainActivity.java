package com.example.inflate;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {
    private Button inflate_btn;
    private LinearLayout layout;
    private View view;
    private LayoutInflater inflater;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inflate_btn = (Button)findViewById(R.id.inflate_btn);
        // activity_main.xml layout id 연동
        layout = (LinearLayout)findViewById(R.id.inf_layout);
        // 레이아웃 inflate 세팅
        inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.inflate_layout, layout, false);
        inflate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflateEvent();
            }
        });
    }
    public void inflateEvent(){

        layout.addView(view);
        //inflate layout 에 있는 button id 값 가져옴
        Button btn = findViewById(R.id.inflate_layout_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // btn 눌렀을때 inflate 종료시킴
                layout.removeView(view);

            }
        });
    }
}