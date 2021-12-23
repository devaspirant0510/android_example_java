package com.example.roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String TAG = "MainActivity";
    private EditText mEtInsertModel1, mEtInsertModel2, mEtInsertModel3, mEtInsertModel4, mEtUpdatePk, mEtDeletePk;
    private TextView mTvTable;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEtInsertModel1 = findViewById(R.id.et_insert_model1);
        mEtInsertModel2 = findViewById(R.id.et_insert_model2);
        mEtInsertModel3 = findViewById(R.id.et_insert_model3);
        mEtInsertModel4 = findViewById(R.id.et_insert_model4);
        mEtUpdatePk = findViewById(R.id.et_update_pk);
        mEtDeletePk = findViewById(R.id.et_del_pk);

        Button mBtnModelInsert = findViewById(R.id.btn_insert);
        Button mBtnModelUpdate = findViewById(R.id.btn_delete);
        Button mBtnModelDelete = findViewById(R.id.btn_update);

        mBtnModelInsert.setOnClickListener(this);
        mBtnModelUpdate.setOnClickListener(this);
        mBtnModelDelete.setOnClickListener(this);

        mTvTable = findViewById(R.id.tv_table);
        updateUser();

    }

    private void updateUser() {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,
                "dbname4").
                allowMainThreadQueries().build();

        userDao = db.userDao();
        String tableText = "";

        Cursor cursor = userDao.queryBetween(1,6);
        for(String val:cursor.getColumnNames()){
            Log.e(TAG, "updateUser: "+val );
        }

        LiveData<List<UserDao.UserInfo>> data = userDao.loadJoinUserInfo();
        data.observe(this, new Observer<List<UserDao.UserInfo>>() {
            @Override
            public void onChanged(List<UserDao.UserInfo> userInfos) {
                for(UserDao.UserInfo info:userInfos){
                    Toast.makeText(getApplicationContext(),info.frameworkName+"",Toast.LENGTH_SHORT).show();

                }
                //Log.e(TAG, "onChanged: "+userInfos.get(0)+ " "+userInfos.get(1) );
            }
        });
//        List<UserDao.UserInfo> list = data.getValue();
//        for (UserDao.UserInfo data1:list){
//            Log.e(TAG, "updateUser: "+data1.frameworkName+"|"+data1.gpuName );
//
//        }

//        Log.e(TAG, "updateUser: "+list.get(0));
//        List<Developer> models = userDao.queryList();
//        for(Developer data:models){
//            tableText += "\n"+data.id+"|"+data.gpu+"|"+data.cpu+"|"+data.ram+"|"+data.language+"|"+data.framework+"|";
//        }
//        List<Model> models = userDao.queryList("승호","생활코딩","야");
//        for (Model data : models) {
//            tableText += "\n" + data.useId + "|" + data.getFirstName() + "|" + data.getLastName() + "|" + data.getTall() + "|" + data.getWeight();
//
//        }
        mTvTable.setText(tableText);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_insert:
                String m1 = mEtInsertModel1.getText().toString();
                String m2 = mEtInsertModel2.getText().toString();
                float m3 = Float.parseFloat(mEtInsertModel3.getText().toString());
                float m4 = Float.parseFloat(mEtInsertModel4.getText().toString());
                Model insertModel = new Model();
                insertModel.init(m1, m2, m3, m4);
//                userDao.insertQuery(m1,m2,m3,m4);
                long[] items = userDao.inertItem(insertModel);
                String iter = "";
                for (long get:items) {
                    iter+=get+",";
                }
                Toast.makeText(getApplicationContext(),"추가된 아이템 아이디 : "+iter,Toast.LENGTH_SHORT).show();
                updateUser();
                break;
            case R.id.btn_delete:
                int primaryKey = Integer.parseInt(mEtDeletePk.getText().toString());
                Model deleteModel = new Model();
                deleteModel.useId = primaryKey;
                int item = userDao.deleteItem(deleteModel);
                Toast.makeText(getApplicationContext(),"삭제된 아이템 개수: "+item,Toast.LENGTH_SHORT).show();
                updateUser();
                break;
            case R.id.btn_update:
                primaryKey = Integer.parseInt(mEtUpdatePk.getText().toString());
                Model updateModel = new Model();
                updateModel.useId = primaryKey;
                m1 = mEtInsertModel1.getText().toString();
                m2 = mEtInsertModel2.getText().toString();
                m3 = Float.parseFloat(mEtInsertModel3.getText().toString());
                m4 = Float.parseFloat(mEtInsertModel4.getText().toString());
                updateModel.init(m1, m2, m3, m4);
                item = userDao.updateItem(updateModel);
                Toast.makeText(getApplicationContext(),"변경된 아이템 개수: "+item,Toast.LENGTH_SHORT).show();
                updateUser();
                break;
        }
    }
}