package com.example.intentex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button next_btn; // Button  정의
    private EditText input_age,input_name,input_company,input_salary; // EditText 정의

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // EditText 아이디 연결
        input_age = (EditText)findViewById(R.id.input_age);
        input_name = (EditText)findViewById(R.id.input_name);
        input_company = (EditText)findViewById(R.id.input_company);
        input_salary = (EditText)findViewById(R.id.input_salary);

        next_btn = (Button)findViewById(R.id.next_btn); // Button 아이디 연결
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // intent 객체 생성
                Intent intent = new Intent(MainActivity.this,SubActivity.class);
                // EditText 에서 값 가져온후 String 으로 변환
                String putAgeS = input_age.getText().toString();
                String putName = input_name.getText().toString();
                String putCompany = input_company.getText().toString();
                String putSalary = input_salary.getText().toString();

                if  (input_name.getText().length() == 0 || input_company.getText().length() == 0 ||
                    input_salary.getText().length() == 0 || putAgeS.length() ==0)  {
                    Toast.makeText(getApplicationContext(), "빈칸을 채워주세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    // intent 에 값 넘김
                    int putAge = Integer.parseInt(putAgeS);
                    intent.putExtra("name", putName);
                    intent.putExtra("age", putAge);
                    intent.putExtra("company", putCompany);
                    intent.putExtra("salary", putSalary);
                    Log.e("MainActivity",putName);
                    startActivity(intent);
                }
            }
        });
    }
}