package com.example.recyclerviewapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.recyclerviewapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mb;
    private View root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mb = ActivityMainBinding.inflate(getLayoutInflater());
        root = mb.getRoot();
        setContentView(root);
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false);
        mb.list.setLayoutManager(manager);
        Adapter adapter = new Adapter(getApplicationContext());
        adapter.addItem(new ChatData("google","당신을 저희회사로 데려가고 싶습니다.","11:58",Define.OTHER_MESSAGE));
        adapter.addItem(new ChatData("seungho","아이 원트 오십억 달라","11:59",Define.MY_MESSAGE));
        adapter.addItem(new ChatData("2021년1월12일",null,null,Define.TIME_BOUNDING));
        adapter.addItem(new ChatData("google","좋습니다","00:01",Define.OTHER_MESSAGE));
        adapter.addItem(new ChatData("google","바로 면접문제 들어가겠습니다. 차가 울면?","00:01",Define.OTHER_MESSAGE));

        adapter.addItem(new ChatData("seungho","잉카","00:01",Define.MY_MESSAGE));
        adapter.addItem(new ChatData("google","홀리씻 ㅈㄴ 똑똑하네","00:03",Define.OTHER_MESSAGE));
        adapter.addItem(new ChatData("seungho","유어 웰컴","00:05",Define.MY_MESSAGE));

        adapter.addItem(new ChatData("google","개미네 집 주소는","00:06",Define.OTHER_MESSAGE));
        adapter.addItem(new ChatData("seungho","허리도 가늘군 만지면 부러지리","00:06",Define.MY_MESSAGE));

        adapter.addItem(new ChatData("google","와 대박이다 정말 아주 굿이에요 굿","00:06",Define.OTHER_MESSAGE));
        mb.list.setAdapter(adapter);
    }
}