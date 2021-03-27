package com.example.fusedlocationprovider;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    private ArrayList<Item> list = new ArrayList<>();

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View root = null;
        if (convertView == null) {
            Context context = parent.getContext();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_layout, parent, false);
            TextView title = convertView.findViewById(R.id.title);
            TextView value = convertView.findViewById(R.id.value);
            Item item = list.get(position);
            Log.e("s",item.getName());
            title.setText(item.getName());
            value.setText(item.getValue());
        }
        return convertView;
    }
    public void addItem(Item item){
        list.add(item);
    }
}
