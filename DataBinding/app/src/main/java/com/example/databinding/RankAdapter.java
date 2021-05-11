package com.example.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databinding.databinding.RvItemLayoutBinding;

import java.util.ArrayList;

public class RankAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<RankingItem> list = new ArrayList<>();
    private RvItemLayoutBinding mb;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mb = RvItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MainViewHolder(mb.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof  MainViewHolder){
            mb.setRankingItem(list.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void addItem(RankingItem item){
        list.add(item);
    }
    private class MainViewHolder extends RecyclerView.ViewHolder{
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
