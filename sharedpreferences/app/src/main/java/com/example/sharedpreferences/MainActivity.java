package com.example.sharedpreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.sharedpreferences.R;
import com.example.sharedpreferences.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mb;
    private int m_score,m_level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mb = ActivityMainBinding.inflate(getLayoutInflater());
        View root = mb.getRoot();
        setContentView(root);

        SharedPreferences sharedPreferences = getSharedPreferences("shared",MODE_PRIVATE);

        String userName = sharedPreferences.getString("name","");
        m_level = sharedPreferences.getInt("level",0);
        m_score = sharedPreferences.getInt("score",0);
        mb.etTest.setText(userName);
        mb.tvLevel.setText("Level : "+m_level);
        mb.tvScore.setText("Score : "+m_score);
        mb.btnLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_level+=1;
                mb.tvLevel.setText("Level : "+m_level);

            }
        });
        mb.btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_score+=1;
                mb.tvScore.setText("Score : "+m_score);
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sharedPreferences = getSharedPreferences("shared",MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        String value = mb.etTest.getText().toString();
        editor.putString("name",value);
        editor.putInt("level",m_level);
        editor.putInt("score",m_score);
        editor.apply();

    }

}