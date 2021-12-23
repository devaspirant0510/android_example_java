package com.example.handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private TextView tvTime;
    private static final String TAG = "MainActivity";
    TimeHandler handler = new TimeHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTime = findViewById(R.id.tv_time);
        TimeThread thread = new TimeThread();
        thread.start();


    }

    public class TimeThread extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (true) {
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                Log.e(TAG, "onCreate: " + format1.format(date));
                try {
                    Thread.sleep(1000);
                    Message msg = handler.obtainMessage();
                    Bundle bundle = new Bundle();
                    bundle.putString("date", format1.format(date));
                    msg.setData(bundle);
                    handler.sendMessage(msg);

                    //Handler handler = new Handler(Looper.getMainLooper());


//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            tvTime.setText(format1.format(date));
//                        }
//                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class TimeHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            String data = msg.getData().getString("date");
            tvTime.setText(data);
        }

    }
}