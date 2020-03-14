/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/3/20 11:47 AM
 */

package com.example.hautomation.adapters.transaction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hautomation.fragments.recenttransaction.RecentTransactionMvc;
import com.example.hautomation.fragments.recenttransaction.RecentTransactionMvcImpl;
import com.example.hautomation.models.TransactionModel;

import java.util.ArrayList;
import java.util.List;

public class TransactionRecyclerADapter extends RecyclerView.Adapter<TransactionRecyclerADapter.MyviewHolder>
        implements TransactionItemViewMvc.Listener{
    public static final int TYPE_ITEM=0,TYPE_DATE=1;
    private ArrayList<TransactionModel> items;
    private ArrayList<TransactionModel> tempItems;
    Context mContext;
    RecentTransactionMvc.Listener mListener;

    public TransactionRecyclerADapter(Context mContext, RecentTransactionMvcImpl recentTransactionMvc) {
        this.mContext = mContext;
        items=new ArrayList<>();
        tempItems=new ArrayList<>();
    }

    public TransactionRecyclerADapter(Context context, RecentTransactionMvc.Listener listener) {
        this.mContext=context;
        items=new ArrayList<>();
        tempItems=new ArrayList<>();
        mListener=listener;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TransactionItemViewMvc mvc=new TransactionItemViewImpl(LayoutInflater.from(mContext),parent,viewType);
        mvc.registerListener(this);
        return new MyviewHolder(mvc);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        holder.viewMvc.bindTransaction(getItem(position));
    }

    private TransactionModel getItem(int position) {
        return position<items.size()?items.get(position):null;
    }
    @Override
    public int getItemCount() {
        return 120;
    }
    @Override
    public int getItemViewType(int position) {

        return position%6==0?TYPE_DATE:TYPE_ITEM;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }


    public void clear() {
        this.items.clear();
    }
    public void addAll(List list){
        items.clear();
        items.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public void onTransactionClicked(TransactionModel model) {

    }

    @Override
    public void addItem(TransactionModel model) {

    }

    @Override
    public void performSearch(String key) {

    }

    static class MyviewHolder extends RecyclerView.ViewHolder{
        TransactionItemViewMvc viewMvc;
        public MyviewHolder(@NonNull TransactionItemViewMvc itemView) {
            super(itemView.getRootView());
            viewMvc=itemView;
        }
    }
}
