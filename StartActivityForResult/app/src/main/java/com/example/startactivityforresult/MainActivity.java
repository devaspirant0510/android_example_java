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
    private Button go_btn;
    private TextView text_1;
    private static final int REQUEST_CODE=300;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        go_btn = (Button)findViewById(R.id.btn_go);
        text_1 = (TextView)findViewById(R.id.text_1);

        go_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),subActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
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
        if (requestCode==REQUEST_CODE){
            String result_text = data.getStringExtra("editText_msg");
            text_1.setText(result_text);

        }
    }
}