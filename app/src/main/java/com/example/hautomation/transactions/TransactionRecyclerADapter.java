/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 2/29/20 11:49 AM
 */

package com.example.hautomation.transactions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hautomation.R;

import java.util.ArrayList;
import java.util.List;

public class TransactionRecyclerADapter extends RecyclerView.Adapter<TransactionRecyclerADapter.ViewHolder> {


    private ArrayList items;

    public interface ItemClickListener{
        public void onItemClick(int pos);
    }
    Context mContext;
    ItemClickListener mitemClickListener;

    public TransactionRecyclerADapter(Context mContext,ItemClickListener listener){
        this.mContext = mContext;
        this.mitemClickListener=listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.recent_transaction_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mitemClickListener!=null)mitemClickListener.onItemClick(getAdapterPosition());
                }
            });
        }
    }
    public void clear() {
        this.items.clear();
    }
    public void addAll(List list){
        items.clear();
        items.addAll(list);
        notifyDataSetChanged();
    }
}
