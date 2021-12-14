package com.wyjson.circlefriendsdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wyjson.circlefriendsdemo.R;


public class CircleFriendsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Override
    public int getItemCount() {
        return 50;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_circle_friends, parent, false);
        MyViewHolder holder = new MyViewHolder(convertView);
        holder.tvTitle = convertView.findViewById(R.id.tv_title);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holders, final int position) {
        MyViewHolder holder = ((MyViewHolder) holders);
        holder.tvTitle.setText("position:" + position);
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder {

        private MyViewHolder(View itemView) {
            super(itemView);
        }

        private TextView tvTitle;

    }

}
