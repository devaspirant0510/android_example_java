
package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    Button button;
    ProgressBar progressBar;
    TextView progress_text;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        progressBar = findViewById(R.id.progressBar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.postDelayed(new Runnable() {
                    @Override

                    public void run() {
//                        ProgressThread thread = new ProgressThread();
//                        thread.start();
                        new Thread(new Runnable() {
                            boolean run =false;
                            int values = 0;
                            @Override
                            public void run() {
                                run = true;
                                while(run){
                                    if (values>=100){
                                        break;
                                    }
                                    values+=1;
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            progressBar.setProgress(values);

                                        }
                                    });
                                    try {
                                        Thread.sleep(250);
                                    }catch (Exception e){}


                                }
                            }

                        }).start();
                    }
                },3000);
            }
        });
    }

    class ProgressThread extends Thread{
        boolean run = false;
        int values = 0;
        public void run(){
            run = true;
            while(run){
                if (values>=100){
                    break;
                }
                values+=1;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setProgress(values);

                    }
                });
                try {
                    Thread.sleep(250);
                }catch (Exception e){}


            }
        }
    }

}