package com.example.LoginRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Register extends AppCompatActivity {
    private EditText id_txt;
    private EditText passwd_txt;
    private EditText txt_name;
    private EditText txt_phone;
    private EditText txt_age;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        id_txt = (EditText)findViewById(R.id.id_txt);
        passwd_txt = (EditText)findViewById(R.id.passwd_txt);
        txt_name = (EditText)findViewById(R.id.txt_name);
        txt_phone = (EditText)findViewById(R.id.txt_phone);
        txt_age = (EditText)findViewById(R.id.txt_age);

        submitButton = (Button)findViewById(R.id.submit_btn);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = id_txt.getText().toString();
                String userPassword = passwd_txt.getText().toString();
                String userName = txt_name.getText().toString();
                int userAge = Integer.parseInt(txt_phone.getText().toString());
                String userPhone = txt_age.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            Toast.makeText(getApplicationContext(),"asdf",Toast.LENGTH_SHORT).show();
                            if (success) { // 회원등록에 성공한 경우
                                Toast.makeText(getApplicationContext(),"회원 등록에 성공하였습니다.",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Register.this, Login.class);
                                startActivity(intent);
                            } else { // 회원등록에 실패한 경우
                                Toast.makeText(getApplicationContext(),"회원 등록에 실패하였습니다.",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(),"asdf",Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }

                    }
                };
//                // 서버로 Volley를 이용해서 요청을 함.
                RegisterRequest registerRequest = new RegisterRequest(userID,userPassword,userName,userAge, userPhone,responseListener);
                RequestQueue queue = Volley.newRequestQueue(Register.this);
                queue.add(registerRequest);
//
            }
        });
    }
}