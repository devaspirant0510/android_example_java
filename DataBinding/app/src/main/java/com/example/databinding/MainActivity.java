package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mb = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mb.getRoot());


        init();
    }

    private void init() {
        mb.setTextData(new TextData("이야","이것이 바로","데이타 바인딩이구나ㅋㅋㅋ"));
        RankAdapter adapter = new RankAdapter();
        adapter.addItem(new RankingItem(1,"Vue js",170.0f));
        adapter.addItem(new RankingItem(2,"React js",154.0f));
        adapter.addItem(new RankingItem(3,"Angular",64));
        adapter.addItem(new RankingItem(4,"Angular js",59.5f));
        adapter.addItem(new RankingItem(5,"JQuery",53.8f));
        adapter.addItem(new RankingItem(6,"Django",51.2f));
        adapter.addItem(new RankingItem(7,"Express",49.6f));
        adapter.addItem(new RankingItem(8,"Spring",38.7f));
        adapter.addItem(new RankingItem(9,"ASP.Net core",18.7f));
        adapter.addItem(new RankingItem(10,"ASP.Net",11.9f));


        mb.rvList.setAdapter(adapter);
    }
}