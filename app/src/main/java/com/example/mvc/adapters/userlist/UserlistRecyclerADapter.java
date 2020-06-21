/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.adapters.userlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvc.screens.fragments.userlist.UserlistMvc;
import com.example.mvc.models.TransactionModel;
import com.example.mvc.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserlistRecyclerADapter extends RecyclerView.Adapter<UserlistRecyclerADapter.MyviewHolder>
        implements UserlistViewMvc.Listener{
public static final int TYPE_ITEM=0,TYPE_DATE=1;
    private ArrayList<TransactionModel> items;
    Context mContext;
    UserlistMvc mListener;

    public UserlistRecyclerADapter(Context mContext, UserlistMvc listener) {
        this.mContext = mContext;
        this.mListener=listener;
        items=new ArrayList<>();
    }


    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        UserlistViewMvc mvc=new UserlistViewMvcImpl(LayoutInflater.from(mContext),parent,viewType);
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
    public void onUserClicked(UserModel model) {

    }

    static class MyviewHolder extends RecyclerView.ViewHolder{
        UserlistViewMvc viewMvc;
        public MyviewHolder(@NonNull UserlistViewMvc itemView) {
            super(itemView.getRootView());
            viewMvc=itemView;
        }
    }
}
