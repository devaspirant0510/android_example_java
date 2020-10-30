package com.example.recycle_menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class inputLayer extends AppCompatActivity {
    private EditText input_name;
    private EditText input_phone_number;
    private EditText input_address;
    private Button submit;

    private ArrayList<Maindata> arrayList;
    private RecyclerView recyclerView;
    private MainAdapter  mainAdapter;
    private LinearLayoutManager linearLayoutManager;
    private final int REQUEST =1;

    // 로그 생성
    private static String TAG = "input_layer";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_layer);

        // 버튼 아이디 불러오기
        input_name = (EditText)findViewById(R.id.input_name);
        input_address = (EditText)findViewById(R.id.input_address);
        input_phone_number= (EditText)findViewById(R.id.input_phone_number);



        // submit 버튼이 클릭됬을떄
        submit = (Button)findViewById(R.id.submit_profile);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // intent 메인 액티비티로 전환
                Intent intent  = new Intent();
                // intent 에 값 전달
                // 에딧텍스트의 값을 getText 로 가져온후 문자열로 변환 ( EditText -> String)
                String userName=input_name.getText().toString();
                String phoneNum=input_phone_number.getText().toString();
                String userAddress=input_address.getText().toString();
                Toast.makeText(getApplicationContext(),userName,Toast.LENGTH_SHORT).show();
                intent.putExtra("user_name",userName);
                intent.putExtra("user_phone",phoneNum);
                intent.putExtra("user_address",userAddress);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}