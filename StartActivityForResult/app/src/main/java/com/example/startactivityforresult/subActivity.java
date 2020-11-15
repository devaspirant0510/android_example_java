package com.example.startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class subActivity extends AppCompatActivity {
    private Button submit_btn;
    private EditText editT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        editT = (EditText)findViewById(R.id.editT);

        submit_btn = (Button)findViewById(R.id.submit_btn);
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                String editT_str = editT.getText().toString();
                intent.putExtra("editText_msg",editT_str);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}