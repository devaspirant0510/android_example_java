package com.example.recycle_menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewFolder> {

    private ArrayList<Maindata> arrayList;

    public MainAdapter(ArrayList<Maindata> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MainAdapter.CustomViewFolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        CustomViewFolder holder = new CustomViewFolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MainAdapter.CustomViewFolder holder, int position) {
        holder.profile.setImageResource(arrayList.get(position).getProfile());
        holder.user_name.setText(arrayList.get(position).getUser_name());
        holder.address.setText(arrayList.get(position).getAddress());
        holder.phone_number.setText(arrayList.get(position).getPhone_number());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curName  = holder.user_name.getText().toString();
                Toast.makeText(v.getContext(),curName,Toast.LENGTH_SHORT).show();
                //String curAddress = holder.address.getText().toString()
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                remove(holder.getAdapterPosition());
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }
    public void remove(int position){
        try{
            arrayList.remove(position);
            notifyItemRemoved(position);
        }catch(IndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
    }

    public class CustomViewFolder extends RecyclerView.ViewHolder {

        protected ImageView profile;
        protected TextView user_name;
        protected TextView address;
        protected TextView phone_number;

        public CustomViewFolder(@NonNull View itemView) {
            super(itemView);
            this.profile = (ImageView) itemView.findViewById(R.id.iv_profile);
            this.user_name = (TextView) itemView.findViewById(R.id.user_name);
            this.address = (TextView) itemView.findViewById(R.id.address);
            this.phone_number = (TextView)itemView.findViewById(R.id.phone_number);
        }
    }
}
