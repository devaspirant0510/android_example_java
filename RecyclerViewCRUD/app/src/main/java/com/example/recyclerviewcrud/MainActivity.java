package com.example.recyclerviewcrud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity  {
    private RecyclerView recyclerView;
    private Button button;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    public void init() {
        button = findViewById(R.id.create);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new Adapter();
        recyclerView.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog dialog = new CustomDialog(MainActivity.this);
                dialog.setCallback(new Callback() {
                    @Override
                    public void setOnClick(String name, int age) {
                        adapter.addItem(new Data(name,age));

                    }
                });
                dialog.show();

            }
        });
        adapter.setCallback(new Adapter.Callback() {
            @Override
            public void onClick(View v, int pos) {
                CustomDialog dialog = new CustomDialog(MainActivity.this);
                dialog.setCallback(new Callback() {
                    @Override
                    public void setOnClick(String name, int age) {
                        adapter.list.set(pos,new Data(name,age));
                        adapter.notifyItemChanged(pos);
                    }
                });
                dialog.show();
            }

            @Override
            public void onLongClick(View v, int pos) {
                Toast.makeText(getApplicationContext(),"d",Toast.LENGTH_SHORT).show();
                adapter.delItem(pos);
                adapter.notifyItemRemoved(pos);
            }
        });

    }

}