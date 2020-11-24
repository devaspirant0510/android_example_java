package com.example.intentex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {
    // Button TextView 정의
    private Button back_btn;
    private TextView output_name,output_age,output_company,output_salary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // putExtra 로 보낸 값 전달받을 intent 선언
        Intent intent = getIntent();
        
        // intent 값 가져옴
        String getName = intent.getStringExtra("name");
        int getAge = intent.getIntExtra("age",1); // 1은 디폴트 값 ( 숫자 아무거나 상관없음)
        String getCompany = intent.getStringExtra("company");
        String getSalary = intent.getStringExtra("salary");

        // xml id 값 연결
        output_name = (TextView)findViewById(R.id.output_name);
        output_age = (TextView)findViewById(R.id.output_age);
        output_company = (TextView)findViewById(R.id.output_company);
        output_salary = (TextView)findViewById(R.id.output_salary);

        // TextView 의  텍스트를 intent 에서 가져온 값으로 지정
        output_name.setText(getName);
        output_age.setText(String.valueOf(getAge));
        output_company.setText(getCompany);
        output_salary.setText(getSalary);

        back_btn = (Button)findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back_btn 눌렀을시 MainActivity 로
                Intent intent = new Intent(SubActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
}