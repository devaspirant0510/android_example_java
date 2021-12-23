package com.example.kakaologinnewversion;

import android.app.Application;

import com.kakao.sdk.common.KakaoSdk;

public class GlobalApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        KakaoSdk.init(this,"c7f8508856e8028e0a40cd5236c2fa2e");
        
    }
}
