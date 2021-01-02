package com.example.http;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ThreadPoolExecutor;

public class MainActivity extends AppCompatActivity {
    TextView log;
    EditText etext;
    ScrollView scrollView;
     //requestHandler handler = new requestHandler();
    Handler handler = new Handler();
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etext = findViewById(R.id.etext);
        button = findViewById(R.id.button);
        scrollView = findViewById(R.id.view);
        log = findViewById(R.id.log);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                String getText = etext.getText().toString();
                                try{
                                    URL url = new URL(getText);
                                    HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                                    if (connection!=null){
                                        connection.setConnectTimeout(10000);
                                        connection.setRequestMethod("GET");
                                        connection.setDoInput(true);
                                        connection.setDoOutput(true);
                                        int requestCode = connection.getResponseCode();
                                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                                        String line = null;

                                        while (true){
                                            line = bufferedReader.readLine();
                                            if (line==null){
                                                break;
                                            }
                                            println(line);
                                        }
                                    }
                                }catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }
                        }).start();
                    }
                });
                /*RequestThread requestThread = new RequestThread();
                requestThread.start();*/
            }
        });

    }
    public void println(String data){
        //log.append(data+"\n");
        Bundle bundle = new Bundle();
        bundle.putString("data",data);
        Message msg  = handler.obtainMessage();
        msg.setData(bundle);
        Log.e("adsf",data);
    }
    class RequestThread extends Thread{
        public void run() {

        }
    }
    class requestHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Bundle get = msg.getData();
            String getdata = get.getString("data");
            log.setText(getdata);
        }
    }
}