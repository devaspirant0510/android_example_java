package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;


public class Adapter extends BaseAdapter{
    ArrayList<Item> list = new ArrayList<Item>();

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
        if (convertView == null){
            Context context = parent.getContext();
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE
            );
            convertView = inflater.inflate(R.layout.item_layout,parent,false);
            // 레이아웃에서 id 값으로 textView 값 가져오기
            TextView korId = (TextView)convertView.findViewById(R.id.kor);
            TextView engId = (TextView)convertView.findViewById(R.id.eng);

            // 리스트에서 엘리먼트값 가져오기
            Item getList = list.get(position);
            String kor = getList.getKor();
            String eng = getList.getEng();

            korId.setText(kor);
            engId.setText(eng);
        }
        return convertView;
    }
    public void addItem(String kor, String eng){
        Item item = new Item();
        item.setKor(kor);
        item.setEng(eng);
        list.add(item);
    }
}
