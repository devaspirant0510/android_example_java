package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list_view);
        Adapter adapter = new Adapter();
        adapter.addItem("수렴","convergence");
        adapter.addItem("역전파","backpropagation");
        adapter.addItem("임계값","threshold");
        adapter.addItem("최적화","optimization");
        adapter.addItem("신경망","neural network");
        adapter.addItem("데이터 분석","data analysis");
        adapter.addItem("정규화","regularization");
        adapter.addItem("특성","feature");
        listView.setAdapter(adapter);
    }


}