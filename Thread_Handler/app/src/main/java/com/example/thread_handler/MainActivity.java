package com.example.thread_handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.TreeSet;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int num = 0;
    private Button btnStartThread, btnCheckValue;
    private TextView tvCurrentValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }

    private void init() {
        tvCurrentValue = findViewById(R.id.thread1);
        btnStartThread = findViewById(R.id.start_btn1);
        btnCheckValue = findViewById(R.id.check_val);
        btnStartThread.setOnClickListener(this);
        btnCheckValue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_btn1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (num < 100) {
                            num += 1;
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }).start();
//                Thread1 thread1 = new Thread1(num);
//                thread1.start();
                return;
            case R.id.check_val:
                tvCurrentValue.setText(String.valueOf(num));
                return;
            default:
                break;
        }


    }

    class Thread1 extends Thread {
        private int val;

        public Thread1(int val) {
            this.val = val;
        }

        @Override
        public void run() {
            while (this.val < 100) {
                this.val += 1;
                num = this.val;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    class Thread2 implements Runnable {

        @Override
        public void run() {
            while (num < 100) {
                num += 1;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}