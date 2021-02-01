package com.example.sharedpreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import com.example.sharedpreferences.R;
import com.example.sharedpreferences.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mb;
    private View root;
    private int m_score,m_level;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("level",m_level);
        outState.putInt("score",m_score);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences sharedPreferences = getSharedPreferences("gson",0);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        String value = mb.etTest.getText().toString();
        editor.putString("value",value);
        editor.apply();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mb = ActivityMainBinding.inflate(getLayoutInflater());
        root = mb.getRoot();
        setContentView(root);
        if (savedInstanceState!=null){
            m_level=savedInstanceState.getInt("level");
            m_score=savedInstanceState.getInt("score");
            mb.tvLevel.setText("level : "+m_level);
            mb.tvScore.setText("socre : "+m_score);
        }
        SharedPreferences sharedPreferences = getSharedPreferences("gson",0);
        String get = sharedPreferences.getString("value","null");
        mb.etTest.setText(get);
        mb.btnLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_level+=1;
                mb.tvLevel.setText("level : "+m_level);

            }
        });
        mb.btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_score+=1;
                mb.tvScore.setText("score : "+m_score);
            }
        });

    }


}