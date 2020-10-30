package com.example.recycle_menu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Maindata> arrayList;
    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;
    private LinearLayoutManager linearLayoutManager;
    private int REQUEST =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.view_recycle);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList= new ArrayList<>();
        mainAdapter =new MainAdapter(arrayList);
        recyclerView.setAdapter(mainAdapter);
        Button btn  = (Button)findViewById(R.id.add_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, inputLayer.class);
                startActivityForResult(intent,REQUEST);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST){
            if (resultCode != RESULT_OK){
                return;
            }
            else {
                String U_name,U_phone,U_address;
                U_name = data.getExtras().getString("user_name");
                U_phone = data.getExtras().getString("user_phone");
                U_address = data.getExtras().getString("user_address");
                Toast.makeText(getApplicationContext(),U_name,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),U_address,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),U_phone,Toast.LENGTH_SHORT).show();
                Maindata maindata = new Maindata(R.drawable.ic_launcher_background, U_name, U_address,U_phone);
                arrayList.add(maindata);
                System.out.println(arrayList);

                mainAdapter.notifyDataSetChanged();
            }
        }
    }
}
