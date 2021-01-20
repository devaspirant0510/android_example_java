package com.example.sqlitehelper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;

import com.amitshekhar.DebugDB;
import com.example.sqlitehelper.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mb;
    private View root;
    private SQLiteDatabase sqlDB;
    private String dbPath;
    private String tableName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mb = ActivityMainBinding.inflate(getLayoutInflater());
        root = mb.getRoot();
        setContentView(root);

        DebugDB.getAddressLog();
        mb.openTableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbPath = mb.openTableEt.getText().toString();
                openDB(dbPath);
            }
        });

        mb.createTableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                tableName = mb.createTableEt.getText().toString();
//                createTBL(tableName);

            }
        });
        mb.insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dbName = mb.dbName.getText().toString();
                int dbAge = Integer.parseInt(mb.dbAge.getText().toString());
                int dbBorn = Integer.parseInt(mb.dbBorn.getText().toString());
                String dbRegion = mb.dbRegion.getText().toString();
                insertTBL(dbName, dbAge, dbBorn, dbRegion);
            }
        });
        mb.searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sqlDB != null) {
                    String sql = "select name,age,born,region from mytable";
                    Cursor cursor = sqlDB.rawQuery(sql, null);
                    println("조회된  데이터 개수 :" + cursor.getCount());
                    println("-------------------------------------------------------------");
                    println("|  index  |  name  |  age  |  born  |  region  |");
                    println("-------------------------------------------------------------");
                    for (int i = 0; i < cursor.getCount(); i++) {
                        cursor.moveToNext();
                        println("| " + i + "번째 데이타 |" + cursor.getString(0) + " | " + cursor.getString(1) + " | "
                                + cursor.getString(2) + " | " + cursor.getString(3) + " |");
                    }
                    println("-------------------------------------------------------------");
                    cursor.close();
                }

            }
        });


    }

    private void insertTBL(String dbName, int dbAge, int dbBorn, String dbRegion) {
        println("insert data 호출됨");
        if (sqlDB != null) {
            String sql = "insert into mytable (name,age,born,region) values(?,?,?,?)";
            Object[] params = {dbName, dbAge, dbBorn, dbRegion};
            sqlDB.execSQL(sql, params);
            println("데이터 추가함" + sql);
        } else {
            println("db를 오픈하세요");
        }
    }

    private void createTBL(String tableName) {
        println("create 호출됨");
        SqlHelper sqlHelper = new SqlHelper(this,tableName,null,1);
        sqlDB = sqlHelper.getWritableDatabase();
/*        if (sqlDB != null) {
            String sql = "create table " + tableName + "(_id integer PRIMARY KEY autoincrement," +
                    "name text,age integer,born integer,region text)";
            sqlDB.execSQL(sql);
            println("table 생성됨");
        } else {
            println("db를 오픈하세요");
        }*/
    }

    public void println(String data) {
        mb.log.append(data + "\n");
    }

    public void openDB(String dbName) {
        println("openDB 호출됨");
        sqlDB = openOrCreateDatabase(dbName, MODE_PRIVATE, null);
        if (sqlDB != null) {
            println("데이터베이스 오픈됨");
        }


    }

    class SqlHelper extends SQLiteOpenHelper {

        public SqlHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            println("create 호출됨");
            String tableName = "customer";
            String sql = "create table if not exists" + tableName + "(_id integer PRIMARY KEY autoincrement," +
                    "name text,age integer,born integer,region text)";
            createTBL("customer");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            println("onUpgrade 호출"+"구버전"+oldVersion+"신버전"+newVersion);
            if (newVersion>1){
                String tableName = "customer";
                db.execSQL("drop table if exists "+tableName);
            }


        }
    }
}