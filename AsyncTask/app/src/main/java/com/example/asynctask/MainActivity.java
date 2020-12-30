package com.example.asynctask;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button button;
    ProgressBar progressBar;
    TextView textView;

    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        progressBar = findViewById(R.id.progressBar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask().execute();
            }
        });
    }
    class AsyncTask extends android.os.AsyncTask<Void, Integer, Void>{
        int val = 0;
        @Override
        protected Void doInBackground(Void... voids) {
            boolean run = true;

            while (run){
                if (val == 100){
                    break;
                }
                try{
                    Thread.sleep(40);

                }catch (Exception e){}
                    val+=1;
                    publishProgress(val);
                }
                return null;
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }
    }
}