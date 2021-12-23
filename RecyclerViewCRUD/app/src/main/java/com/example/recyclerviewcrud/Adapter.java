package com.example.recyclerviewcrud;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentSkipListMap;

public class Adapter extends RecyclerView.Adapter {
    protected ArrayList<Data> list = new ArrayList<>();
    private Callback callback = null;
    public void setCallback(Callback callback){
        this.callback = callback;
    }
    public interface Callback{
        void onClick(View v,int pos);
        void onLongClick(View v, int pos);
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new Information(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof Information){
            ((Information) holder).setItem(position);
        }
    }

    public void addItem(Data data){
        list.add(data);
    }
    public void delItem(int pos){
        list.remove(pos);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class Information extends RecyclerView.ViewHolder{
        TextView index;
        TextView name;
        TextView age;
        public Information(@NonNull View itemView) {
            super(itemView);
            index = itemView.findViewById(R.id.index);
            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition() ;
                    if (pos != RecyclerView.NO_POSITION) {
                        callback.onClick(v,pos);
                    }

                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = getAdapterPosition() ;
                    if (pos != RecyclerView.NO_POSITION) {
                        callback.onLongClick(v,pos);
                    }
                    return false;
                }
            });
        }
        public void setItem(int position){
            Data data = list.get(position);
            name.setText(data.getName());
            age.setText(String.valueOf(data.getAge()));

        }
    }
}
