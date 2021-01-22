package com.example.recyclerviewapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<ChatData> list = new ArrayList<>();
    Context context;
    public Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (viewType == Define.MY_MESSAGE){
            view = inflater.inflate(R.layout.my_message_layout,parent,false);
            return new MyMessage(view);
        }
        else if (viewType == Define.OTHER_MESSAGE){
            view = inflater.inflate(R.layout.other_message_layout,parent,false);
            return new OtherMessage(view);
        }
        else{
            view = inflater.inflate(R.layout.time_boundary,parent,false);
            return new TimeBounding(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof OtherMessage){
            ((OtherMessage) holder).setItem(list.get(position));

        }
        else if (holder instanceof  MyMessage){
            ((MyMessage) holder).setItem(list.get(position));

        }
        else if (holder instanceof  TimeBounding){
            ((TimeBounding) holder).date.setText(list.get(position).getName());
        }

    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void addItem(ChatData data){
        list.add(data);
    }
    public class OtherMessage extends RecyclerView.ViewHolder{
        TextView otherName;
        TextView otherComment;
        TextView otherTime;
        public OtherMessage(@NonNull View itemView) {
            super(itemView);
            otherName = itemView.findViewById(R.id.other_name);
            otherComment = itemView.findViewById(R.id.other_comment);
            otherTime = itemView.findViewById(R.id.other_time);
        }
        public void setItem(ChatData data){
            otherName.setText(data.getName());
            otherComment.setText(data.getComment());
            otherTime.setText(data.getTime());
        }
    }

    public class MyMessage extends RecyclerView.ViewHolder{
        TextView myName;
        TextView myComment;
        TextView myTime;

        public MyMessage(@NonNull View itemView) {
            super(itemView);
            myName = itemView.findViewById(R.id.my_name);
            myComment = itemView.findViewById(R.id.my_comment);
            myTime = itemView.findViewById(R.id.my_time);
        }
        public void setItem(ChatData data){
           myName.setText(data.getName());
           myComment.setText(data.getComment());
           myTime.setText(data.getTime());

        }
    }
    public class TimeBounding extends RecyclerView.ViewHolder{
        TextView date;
        public TimeBounding(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);

        }
    }
}
