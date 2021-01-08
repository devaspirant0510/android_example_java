package com.example.edittextchangedonlistner;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_text;
    TextView et_text_num;
    int nowLen=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_text = findViewById(R.id.et_text);
        et_text_num = findViewById(R.id.et_text_num);
        et_text_num.setText("0/200");
        et_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                int len = et_text.getText().toString().length();
                et_text_num.setText(len + "/200");
                if (len < 100) {

                    et_text_num.setTextColor(Color.parseColor("#000000"));
                } else if (len < 180) {
                    et_text_num.setTextColor(Color.parseColor("#FFA726"));
                } else {
                    et_text_num.setTextColor(Color.parseColor("#E53935"));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }


}
