package com.example.imageload;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.imageload.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mb;
    private View root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mb = ActivityMainBinding.inflate(getLayoutInflater());
        root = mb.getRoot();

        setContentView(root);
        mb.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendImageRequest();
            }
        });
    }

    private void sendImageRequest() {
        ImageView imageView = findViewById(R.id.imageView);
        String url = "https://i.ytimg.com/vi/fe45uETLPBE/maxresdefault.jpg";
        ImageLoadTask loadTask = new ImageLoadTask(url,mb.imageView);
        loadTask.execute();
    }
}