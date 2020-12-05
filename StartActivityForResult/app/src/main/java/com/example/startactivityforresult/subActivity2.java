package com.example.startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class subActivity2 extends AppCompatActivity {
    private Button submit_btn;
    private EditText editT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        submit_btn = (Button)findViewById(R.id.submit_btn);
        editT = (EditText)findViewById(R.id.editT);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String sub2 = editT.getText().toString();
                if (sub2.length() == 0){
                    setResult(RESULT_CANCELED,intent);
                }else{
                    intent.putExtra("sub2",sub2);
                    setResult(RESULT_OK,intent);
                }
                finish();

            }
        });
    }
}