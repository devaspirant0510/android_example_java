package com.example.bottomnavi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Fr1 fr1;
    private Fr2 fr2;
    private Fr3 fr3;
    private Fr4 fr4;
    private Fr5 fr5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fr1 = new Fr1();
        fr2 = new Fr2();
        fr3 = new Fr3();
        fr4 = new Fr4();
        fr5 = new Fr5();
        bottomNavigationView = findViewById(R.id.bottom_menu);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_btn1:
                        setFrag(0);
                        break;
                    case R.id.action_btn2:
                        setFrag(1);
                        break;
                    case R.id.action_btn3:
                        setFrag(2);
                        break;
                    case R.id.action_btn4:
                        setFrag(3);
                        break;
                    case R.id.action_btn5:
                        setFrag(4);
                        break;
                }
            }
        });


    }
    private void setFrag(int n){
        fm = getSupportFragmentManager();
        ft  = fm.beginTransaction();

        switch (n){
            case 0:
                ft.replace(R.id.main_fr,fr1);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_fr,fr2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_fr,fr3);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_fr,fr4);
                ft.commit();
                break;
            case 4:
                ft.replace(R.id.main_fr,fr5);
                ft.commit();
                break;
        }


    }
}