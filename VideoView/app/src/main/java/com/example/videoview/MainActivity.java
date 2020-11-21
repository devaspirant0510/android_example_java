package com.example.videoview;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView; // 미디어 제공
    private MediaController mediaController; //미디어 제어 담당
    private String videoURL = "https://youtu.be/hPXeVHdIdmw?list=PLSAJwo7mw8jn8iaXwT4MqLbZnS-LJwnBd,mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = (VideoView)findViewById(R.id.videoView2);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri= Uri.parse(videoURL);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.start();
    }
}