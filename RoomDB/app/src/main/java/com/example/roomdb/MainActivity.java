package com.example.roomdb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    private EditText mEtInsertModel1, mEtInsertModel2;
    private Button mBtnModel;
    private TextView mTvTable;
    private AppDatabase db;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEtInsertModel1 = findViewById(R.id.et_insert_model1);
        mEtInsertModel2 = findViewById(R.id.et_insert_model2);
        mBtnModel = findViewById(R.id.btn_insert);
        mTvTable = findViewById(R.id.tv_table);


        updateUser();

        mBtnModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t1 = mEtInsertModel1.getText().toString();
                String t2 = mEtInsertModel2.getText().toString();
                Model model = new Model(t1, t2);
                userDao.insertAll(model);
                updateUser();


            }
        });

    }
    private void updateUser(){
         db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "dbname3").
                allowMainThreadQueries().build();

         userDao = db.userDao();
        List<Model> models = userDao.getAll();
        String tableText = "";
        for (Model data:models) {
            tableText += "\n"+data.useId+"|"+data.getFirstName()+"|"+data.getLastName()+"|";

        }
        mTvTable.setText(tableText);

    }
    
}