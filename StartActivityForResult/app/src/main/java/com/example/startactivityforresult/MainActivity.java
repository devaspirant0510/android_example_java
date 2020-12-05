package com.example.startactivityforresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_act1,btn_act2;
    private TextView text_1;
    private static final int REQUEST_CODE_ACT1=300;
    private static final int REQUEST_CODE_ACT2=301;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_act1 = (Button)findViewById(R.id.btn_act1);
        btn_act2 = (Button)findViewById(R.id.btn_act2);
        text_1 = (TextView)findViewById(R.id.text_1);

        btn_act1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),subActivity1.class);
                startActivityForResult(intent,REQUEST_CODE_ACT1);
            }
        });
        btn_act2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),subActivity2.class);
                startActivityForResult(intent,REQUEST_CODE_ACT2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK){
            Toast.makeText(getApplicationContext(),"값을 제대로 받아옴",Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(getApplicationContext(),"값을 제대로 못받아옴",Toast.LENGTH_SHORT).show();
        }
        if (requestCode==REQUEST_CODE_ACT1){
            String result_text1 = data.getStringExtra("sub1");
            text_1.setText(result_text1);
        }
        else if (requestCode==REQUEST_CODE_ACT2){
            String result_text2 = data.getStringExtra("sub2");
            text_1.setText(result_text2);

        }
    }
}