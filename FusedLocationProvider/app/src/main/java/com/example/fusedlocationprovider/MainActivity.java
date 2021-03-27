package com.example.fusedlocationprovider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {
    private FusedLocationProviderClient fusedLocationProviderClient;
    private static final String TAG = "MainActivity";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.information_list);
        Adapter adapter = new Adapter();
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.ACCESS_FINE_LOCATION) &&
                    ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)) {
                // 권한 재요청
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 100);
                return;
            } else {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 100);
                return;
            }
        }
        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Handler handler = new Handler(Looper.getMainLooper());  // 핸들러에 메인 루퍼를 인자로 전달
                        handler.post(new Runnable() {  // 메인 스레드로 Runnable 객체를 보냄, runOnUiThread()함수 사용과 유사

                            @Override
                            public void run() {  // run()함수는 메인 스레드에서 실행 됨
                                adapter.addItem(new Item("경도 (Longitude)", String.valueOf(location.getLongitude())));
                                adapter.addItem(new Item("위도 (Latitude)", String.valueOf(location.getLatitude())));
                                adapter.addItem(new Item("고도 (Altitude)", String.valueOf(location.getAltitude())));
                                adapter.addItem(new Item("제공자 (Provider)", String.valueOf(location.getProvider())));
                                adapter.addItem(new Item("정확도 (Accuracy)", String.valueOf(location.getAccuracy())));
                                adapter.addItem(new Item("수평이동방향 (Bearing)", String.valueOf(location.getBearing())));
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    adapter.addItem(new Item("방위의 정확성 (BearingAccuracyDegree)", String.valueOf(location.getBearingAccuracyDegrees())));
                                }
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                                    Log.e(TAG, "onSuccess: " + location.getElapsedRealtimeUncertaintyNanos());
                                }
                                adapter.addItem(new Item("실시간 나노값 얻기 (getElapsedRealtimeNanos)", String.valueOf(location.getElapsedRealtimeNanos())));
                                adapter.addItem(new Item("인공위성 수 (number of satellites )", String.valueOf(location.getExtras().getInt("satellites "))));
                                adapter.addItem(new Item("속도 (Speed)", String.valueOf(location.getSpeed())));
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    Log.e(TAG, "onSuccess: " + location.getSpeedAccuracyMetersPerSecond());
                                }
                                adapter.addItem(new Item("시간", String.valueOf(location.getTime())));
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    Log.e(TAG, "onSuccess: " + location.getVerticalAccuracyMeters());
                                }
                                adapter.notifyDataSetChanged();
                            }
                        });

                    }
                }).start();
                Toast.makeText(getApplicationContext(), location.getAltitude() + "", Toast.LENGTH_SHORT).show();
            }
        });

        Log.e(TAG, "onCreate: " + adapter.getCount());
        listView.setAdapter(adapter);

    }

    public class ViewThread extends Thread {

        @Override
        public void run() {
            Handler handler = new Handler(Looper.getMainLooper());  // 핸들러에 메인 루퍼를 인자로 전달
            handler.post(new Runnable() {  // 메인 스레드로 Runnable 객체를 보냄, runOnUiThread()함수 사용과 유사
                @Override
                public void run() {  // run()함수는 메인 스레드에서 실행 됨

                }
            });
        }
    }
}