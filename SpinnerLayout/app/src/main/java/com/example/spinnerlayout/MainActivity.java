package com.example.spinnerlayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private Spinner spinner;
    private Button add;
    private Button delete;
    ArrayAdapter<String> arrayAdapter;
    List<String> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.spinner);
        result = (TextView)findViewById(R.id.result);

        add = (Button)findViewById(R.id.add);
        delete = (Button)findViewById(R.id.delete);
        itemList = new ArrayList<>();
        for (int i = 0; i < spinner.getCount(); i++) {
            itemList.add(String.valueOf(spinner.getItemAtPosition(i)));

        }


        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, itemList);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                result.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int getPosition = spinner.getSelectedItemPosition();
                itemList.remove(getPosition);
                arrayAdapter.notifyDataSetChanged();
                result.setText(spinner.getSelectedItem().toString());
            }
        });


    }
    public void show(){

        final EditText edittext = new EditText(getApplicationContext());

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("아이템 추가");
        builder.setMessage("추가할 아이템을 입력하세요");
        builder.setView(edittext);
        builder.setPositiveButton("입력",
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),edittext.getText().toString() ,Toast.LENGTH_LONG).show();
                    itemList.add(edittext.getText().toString());
                    arrayAdapter.notifyDataSetChanged();
                }
            });
        builder.setNegativeButton("취소",
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                }
            });
        builder.show();
    }
}