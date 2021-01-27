package com.example.bottomnavi;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import com.example.bottomnavi.databinding.ActivityMainBinding;

import com.example.bottomnavi.define.Define;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mb;
    private View root;
    private Menu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mb = ActivityMainBinding.inflate(getLayoutInflater());
        root = mb.getRoot();
        setContentView(root);
        mb.bottomNavigationView.setSelectedItemId(R.id.action_btn2);
        setFrag(Define.FRAGMENT_ID_2);
        menu = mb.bottomNavigationView.getMenu();
        mb.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_btn1:
                        setFrag(Define.FRAGMENT_ID_1);
                        item.setIcon(R.drawable.android_select);
                        menu.findItem(R.id.action_btn2).setIcon(R.drawable.cafe_no_select);
                        menu.findItem(R.id.action_btn3).setIcon(R.drawable.document_no_select);
                        menu.findItem(R.id.action_btn4).setIcon(R.drawable.headset_no_select);
                        menu.findItem(R.id.action_btn5).setIcon(R.drawable.transportation_no_select);
                        break;
                    case R.id.action_btn2:
                        setFrag(Define.FRAGMENT_ID_2);
                        item.setIcon(R.drawable.cafe_select);
                        menu.findItem(R.id.action_btn1).setIcon(R.drawable.android_no_select);
                        menu.findItem(R.id.action_btn3).setIcon(R.drawable.document_no_select);
                        menu.findItem(R.id.action_btn4).setIcon(R.drawable.headset_no_select);
                        menu.findItem(R.id.action_btn5).setIcon(R.drawable.transportation_no_select);
                        break;
                    case R.id.action_btn3:
                        setFrag(Define.FRAGMENT_ID_3);
                        item.setIcon(R.drawable.document_select);
                        menu.findItem(R.id.action_btn1).setIcon(R.drawable.android_no_select);
                        menu.findItem(R.id.action_btn2).setIcon(R.drawable.cafe_no_select);
                        menu.findItem(R.id.action_btn4).setIcon(R.drawable.headset_no_select);
                        menu.findItem(R.id.action_btn5).setIcon(R.drawable.transportation_no_select);
                        break;
                    case R.id.action_btn4:
                        setFrag(Define.FRAGMENT_ID_4);
                        item.setIcon(R.drawable.headset_select);
                        menu.findItem(R.id.action_btn1).setIcon(R.drawable.android_no_select);
                        menu.findItem(R.id.action_btn2).setIcon(R.drawable.cafe_no_select);
                        menu.findItem(R.id.action_btn3).setIcon(R.drawable.document_no_select);
                        menu.findItem(R.id.action_btn5).setIcon(R.drawable.transportation_no_select);
                        break;
                    case R.id.action_btn5:
                        setFrag(Define.FRAGMENT_ID_5);
                        item.setIcon(R.drawable.transportation_select);
                        menu.findItem(R.id.action_btn1).setIcon(R.drawable.android_no_select);
                        menu.findItem(R.id.action_btn2).setIcon(R.drawable.cafe_no_select);
                        menu.findItem(R.id.action_btn3).setIcon(R.drawable.document_no_select);
                        menu.findItem(R.id.action_btn4).setIcon(R.drawable.headset_no_select);
                        break;
                }
                Toast.makeText(getApplicationContext(),mb.bottomNavigationView.getSelectedItemId()+"",Toast.LENGTH_SHORT).show();
                return true;
            }
            });
    }
    private void setFrag(int n){
        FragmentTransaction ft  = getSupportFragmentManager().beginTransaction();

        switch (n){
            case Define.FRAGMENT_ID_1:
                ft.replace(R.id.frame,new Fr1());
                ft.commit();
                break;
            case Define.FRAGMENT_ID_2:
                ft.replace(R.id.frame,new Fr2());
                ft.commit();
                break;
            case Define.FRAGMENT_ID_3:
                ft.replace(R.id.frame,new Fr3());
                ft.commit();
                break;
            case Define.FRAGMENT_ID_4:
                ft.replace(R.id.frame,new Fr4());
                ft.commit();
                break;
            case Define.FRAGMENT_ID_5:
                ft.replace(R.id.frame,new Fr5());
                ft.commit();
                break;
        }


    }
}