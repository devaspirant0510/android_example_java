package com.example.kakaologinnewversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.user.UserApi;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import java.security.MessageDigest;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button Login,Logout;
    private ImageView ivProfile;
    private TextView tvEmail,tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login = findViewById(R.id.btn_login);
        Logout = findViewById(R.id.btn_logout);
        ivProfile = findViewById(R.id.iv_profile);
        tvEmail = findViewById(R.id.tv_email);
        tvName = findViewById(R.id.tv_name);
        Function2<OAuthToken, Throwable, Unit> callback  =new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                if (oAuthToken!=null){
                    Toast.makeText(getApplicationContext(),"로그인 성공",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"로그인 실패",Toast.LENGTH_SHORT).show();
                }
                updateKaKaoLoginUI();
                return null;
            }
        };
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (UserApiClient.getInstance().isKakaoTalkLoginAvailable(MainActivity.this)){
                    UserApiClient.getInstance().loginWithKakaoTalk(MainActivity.this, callback);

                }else{
                    UserApiClient.getInstance().loginWithKakaoAccount(MainActivity.this, callback);

                }
            }
        });
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserApiClient.getInstance().logout(new Function1<Throwable, Unit>() {
                    @Override
                    public Unit invoke(Throwable throwable) {
                        updateKaKaoLoginUI();
                        return null;
                    }
                });
            }
        });
        updateKaKaoLoginUI();
//        getAppKeyHash();
    }

    private void updateKaKaoLoginUI() {
        UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
            @Override
            public Unit invoke(User user, Throwable throwable) {
                // 로그인 정보를 가져왔을때
                if (user!=null){
                    Log.e(TAG, "invoke: "+user.getId() );
                    Log.e(TAG, "invoke: "+user.getKakaoAccount().getEmail());
                    Log.e(TAG, "invoke: "+user.getKakaoAccount().getProfile().getNickname() );
                    Log.e(TAG, "invoke: "+user.getKakaoAccount().getProfile().getProfileImageUrl() );
                    tvName.setText(user.getKakaoAccount().getProfile().getNickname());
                    tvEmail.setText(user.getKakaoAccount().getEmail());
                    Glide.with(MainActivity.this).load(user.getKakaoAccount().getProfile().getProfileImageUrl()).into(ivProfile);
                    Login.setVisibility(View.INVISIBLE);
                    Logout.setVisibility(View.VISIBLE);
                }
                // 로그인 정보를 못가져왔을떄
                else{
                    Login.setVisibility(View.VISIBLE);
                    Logout.setVisibility(View.INVISIBLE);

                }
                return null;
            }
        });
    }

    private void getAppKeyHash() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                Log.e(TAG, "getAppKeyHash: " + something);
            }

        } catch (Exception e) {
            Log.e(TAG, "getAppKeyHash: Not Found");

        }
    }
}