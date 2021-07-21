package com.example.videoview;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView; // 미디어 제공
    private MediaController mediaController; //미디어 제어 담당
    private String videoURL = "https://r1---sn-a5msen7s.googlevideo.com/videoplayback?expire=1626892315&ei=uxP4YLyHB-yxz7sPiIqMuAQ&ip=5.11.24.203&id=o-ACC1Vi_IOuNw7v5nRMUNgFJwItsjrNKzfbz_YGb-PqIo&itag=18&source=youtube&requiressl=yes&vprv=1&mime=video%2Fmp4&ns=GR7tjqWdw-dJCUH_75CxqZIG&gir=yes&clen=3396604&ratebypass=yes&dur=87.469&lmt=1622779326931306&fexp=24001373,24007246&c=WEB&txp=5430434&n=VJbCl4o0vbBH10_&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRAIgXt7Vnq0Ka98gdeIxWO_mtvok2x352lcnBdRH1ityPsYCIFs0-vARHSfFBFv3B6K6amNEOQ8eucOiU2MKd9v73wRj&rm=sn-u5ap5p9-3p3l7e&req_id=ca9bf6306d5a3ee&redirect_counter=2&cm2rm=sn-nv4ly7e&cms_redirect=yes&mh=Od&mip=121.135.163.48&mm=34&mn=sn-a5msen7s&ms=ltu&mt=1626870526&mv=m&mvi=1&pl=19&lsparams=mh,mip,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRgIhAPy-dhlwPc9-wkv7b4nEMJ-QAewFQSv1zs-vu3SiAvjbAiEA6DWUjoOb_DPJNjHSqwZz2vL3RmI_hH9ACil9Qu8sOcs%3D";

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