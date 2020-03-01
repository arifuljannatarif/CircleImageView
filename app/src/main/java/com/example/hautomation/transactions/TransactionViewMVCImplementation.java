/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 2/29/20 10:50 AM
 */

package com.example.hautomation.transactions;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.hautomation.R;
import com.example.hautomation.common.BaseOvservableViewMvc;

public class TransactionViewMVCImplementation extends BaseOvservableViewMvc<TransactionRecyclerADapter.ItemClickListener>
        implements TransactionViewMVC, TransactionRecyclerADapter.ItemClickListener,SwipeRefreshLayout.OnRefreshListener {
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    TransactionRecyclerADapter transactionADapter;
    public TransactionViewMVCImplementation(LayoutInflater inflater, ViewGroup parent) {
        setmRootView(inflater.inflate(R.layout.activity_transaction,parent,false));
        initViews();
    }
    public void initViews() {
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        transactionADapter=new TransactionRecyclerADapter(getContext(),this);
        recyclerView.setAdapter(transactionADapter);
        progressBar=findViewById(R.id.progressbar);
        swipeRefreshLayout=findViewById(R.id.swiperefresh);
        swipeRefreshLayout.setOnRefreshListener(this);
    }
    @Override
    public void showProgressbar(boolean state) {
        progressBar.setVisibility(state?View.VISIBLE:View.GONE);
    }
    @Override
    public void onRefresh() {
        for(TransactionRecyclerADapter.ItemClickListener listener:getListensers()){

        }
    }

    @Override
    public void showitems(boolean b) {
        recyclerView.setVisibility(b?View.VISIBLE:View.GONE);
    }

    @Override
    public void onItemClick(int pos) {
        for(TransactionRecyclerADapter.ItemClickListener listener:getListensers()){
            listener.onItemClick(pos);
        }
    }


}
