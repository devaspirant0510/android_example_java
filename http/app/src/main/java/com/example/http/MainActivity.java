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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView tv_log;
    EditText et_url;
    ScrollView scrollView;
    //requestHandler handler = new requestHandler();
    Handler handler = new Handler();
    Button button;
    String line = null;
    String getUrl;
    public static String Tag = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_url = findViewById(R.id.etext);
        button = findViewById(R.id.button);
        scrollView = findViewById(R.id.view);
        tv_log = findViewById(R.id.log);
        getUrl = et_url.getText().toString();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestThread requestThread = new RequestThread();
                requestThread.start();
            }
        });

    }

    public void println(final String data) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                tv_log.append(data + "\n");
            }
        });

        Log.e("adsf", data);
    }

    class RequestThread extends Thread {
        public void run() {
            try {
                URL url = new URL(getUrl);
                Log.e(Tag,url+"");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                if (connection != null) {
                    connection.setConnectTimeout(100000);
                    connection.setRequestMethod("GET");
                    connection.getDoInput();
                    connection.getDoOutput();

                    int reCode = connection.getResponseCode();
                    Log.e(Tag,reCode+"");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    while (true) {
                        line = reader.readLine();
                        if (line == null) {
                            break;
                        }

                        println(line);
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    class requestHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Bundle get = msg.getData();
            String getdata = get.getString("data");
            tv_log.setText(getdata);
        }
    }
}