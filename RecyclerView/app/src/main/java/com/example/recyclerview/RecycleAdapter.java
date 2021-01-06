package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.CustomViewHolder> {
    Context context;
    public RecycleAdapter(Context context){
        this.context = context;
    }
    ArrayList<Item> list = new ArrayList<>();


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_list,parent,false);
        //View iew = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.CustomViewHolder holder, int position) {
        Item getItem = list.get(position);
        holder.setItem(getItem);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void addItem(Item item){
        list.add(item);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView CEO;
        TextView stock;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            CEO = itemView.findViewById(R.id.CEO);
            stock = itemView.findViewById(R.id.stock);

        }
        public void setItem(Item item){
            name.setText(item.getName());
            CEO.setText(item.getCEO());
            stock.setText(item.getStock());
        }
    }
}
