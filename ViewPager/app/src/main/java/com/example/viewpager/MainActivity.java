package com.example.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText move_page;
    Button submit;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        move_page = (EditText)findViewById(R.id.move_page);
        submit = (Button)findViewById(R.id.submit);
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragment3 fragment3 = new Fragment3();
        Fragment4 fragment4 = new Fragment4();
        Fragment5 fragment5 = new Fragment5();
        Fragment6 fragment6 = new Fragment6();
        Fragment7 fragment7 = new Fragment7();
        final viewPagerAdapter adapter = new viewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT);
        adapter.addItem(fragment1);
        adapter.addItem(fragment2);
        adapter.addItem(fragment3);
        adapter.addItem(fragment4);
        adapter.addItem(fragment5);
        adapter.addItem(fragment6);
        adapter.addItem(fragment7);


        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e("onpagescreolled",position+" "+positionOffset+" "+positionOffset);
            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(getApplicationContext(),position+"",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.e("scroll state",state+"");

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int page = Integer.parseInt(move_page.getText().toString());
                int MAX_PAGE = adapter.getCount()-1;
                if (0<=page && page<=MAX_PAGE){
                    viewPager.setCurrentItem(page-1,false);
                }
                else{
                    Toast.makeText(getApplicationContext(),"그런 페이지는 없습니다.",Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}