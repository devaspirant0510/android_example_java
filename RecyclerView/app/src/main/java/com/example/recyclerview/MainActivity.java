package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView_hor,recyclerView_hor_reverse;
    RecyclerView recyclerView_ver,recyclerView_ver_reverse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView_hor = findViewById(R.id.recyclerview_hor);
        recyclerView_hor_reverse = findViewById(R.id.recyclerview_hor_reverse);
        recyclerView_ver = findViewById(R.id.recyclerview_ver);
        recyclerView_ver_reverse = findViewById(R.id.recyclerview_ver_reverse);


    }

    @Override
    protected void onResume() {
        super.onResume();

        RecycleAdapter adapter1 = new RecycleAdapter(this);
        adapter1.addItem(new Item("테슬라","일론머스크","371 usd"));
        adapter1.addItem(new Item("구글","선다 피차이","1740 usd"));
        adapter1.addItem(new Item("쿠팡","김범석","모르겠음"));
        adapter1.addItem(new Item("아마존","제프베조스","3218 usd"));
        adapter1.addItem(new Item("페이스북","마크 저커버그","270 usd"));
        adapter1.addItem(new Item("카카오","조수용,여민수","390,000 krx"));
        makeList(recyclerView_hor,RecyclerView.HORIZONTAL,false,adapter1);
        makeList(recyclerView_hor_reverse,RecyclerView.HORIZONTAL,true,adapter1);

        RecycleAdapter adapter2 = new RecycleAdapter(this);
        adapter2.addItem(new Item("Python","1991년","웹,AI 등등"));
        adapter2.addItem(new Item("JAVA","1995년","웹,앱 등등"));
        adapter2.addItem(new Item("C/C++","1972년","임베디드,게임 등등"));
        adapter2.addItem(new Item("Go","2009년","웹 등등"));
        adapter2.addItem(new Item("C#","2000년","웹,게임,윈도우 등등"));
        adapter2.addItem(new Item("javascript","1995년","웹 등등"));
        makeList(recyclerView_ver,RecyclerView.VERTICAL,false,adapter2);
        makeList(recyclerView_ver_reverse,RecyclerView.VERTICAL,true,adapter2);

    }
    public void makeList(RecyclerView recyclerView,int orientation,boolean reverse,RecycleAdapter adapter){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,orientation,reverse);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}