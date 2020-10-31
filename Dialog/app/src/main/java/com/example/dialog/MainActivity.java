package com.example.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button dialog_btn;
    private TextView tv_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog_btn = (Button)findViewById(R.id.dialog_btn);
        dialog_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("dialog title");
                ad.setMessage("나는 존재합까?");

                final EditText et = new EditText(MainActivity.this);
                ad.setView(et);
                ad.setPositiveButton("네 맞습니다.", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String result = et.getText().toString();
                        tv_test.setText(result);
                        Toast.makeText(getApplicationContext(),"오호 글쿤 당신이 말한"+result+"기억하겠네",Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });
                ad.setNegativeButton("아닌데요", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"아니군",Toast.LENGTH_SHORT).show();
                        tv_test.setText("");
                        dialog.dismiss();
                    }
                });
                ad.show();
            }

        });

        tv_test = (TextView) findViewById(R.id.tv_test);
    }
}