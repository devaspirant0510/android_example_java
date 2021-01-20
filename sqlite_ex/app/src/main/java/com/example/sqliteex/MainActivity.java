package com.example.sqliteex;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.amitshekhar.DebugDB;
import com.example.sqliteex.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mb;
    protected View root;
    private SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mb = ActivityMainBinding.inflate(getLayoutInflater());
        root = mb.getRoot();
        setContentView(root);
        DebugDB.getAddressLog();
        mb.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                println("호출됨");
                String dbName = mb.sqlquery.getText().toString();
                openDB(dbName);


            }
        });
        mb.createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tableName = mb.createTv.getText().toString();
                createTable(tableName);
            }
        });
        mb.insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mb.dbName.getText().toString();
                String strAge = mb.dbAge.getText().toString();
                String mobile = mb.dbMobile.getText().toString();
                int age = Integer.parseInt(strAge);
                insertTable(name,age,mobile);
            }
        });
        mb.searchTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                println("select 호출됨");
                selectData();

            }
        });
    }

    private void selectData() {
        if (database!=null){
            String sql = "select name,age,mobile from mytbl";
            Cursor cursor = database.rawQuery(sql,null);
            println("size "+cursor.getCount());

            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                String name = cursor.getString(0);
                String age = cursor.getString(1);
                String mobile = cursor.getString(2);
                println("name: "+name+"age :"+age+"mobile : "+mobile);


            }
            cursor.close();
        }
    }

    private void insertTable(String name, int age, String mobile) {
        println("insert 호출");
        if (database!=null){
            String sql = "insert into mytbl(name,age,mobile) values(?,?,?)";
            Object[] params = {name,age,mobile};

            database.execSQL(sql,params);
            println("추가함");
        }
        else {
            println("만들어라");
        }
    }


    private void createTable(String tableName) {
        println("createTable 호출");
        if (database!=null){
            String sql = "create table "+tableName+" (_id integer PRIMARY KEY autoincrement,name text,age integer,mobile text)";
            database.execSQL(sql);
            println("테이블 생성됨");
        }
        else {
            Toast.makeText(getApplicationContext(),"db오픈",Toast.LENGTH_SHORT).show();
        }
    }

    private void openDB(String dbName) {
         database = openOrCreateDatabase(dbName,MODE_PRIVATE,null);
        if (database !=null){
            println("데이터페이스 오픈됨");
        }
    }

    public void println(String str){
        mb.tvView.append(str+"\n");
    }
}