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

import java.util.logging.Handler;

public class TransactionViewMVCImplementation extends BaseOvservableViewMvc<TransactionViewMVC.Listener>
        implements TransactionViewMVC, SwipeRefreshLayout.OnRefreshListener {
    SwipeRefreshLayout swipeRefreshLayout;
    ProgressBar progressBar;
    public TransactionViewMVCImplementation(LayoutInflater inflater, ViewGroup parent) {
        setmRootView(inflater.inflate(R.layout.activity_transaction,parent,false));
        try {
            registerListener((Listener) getContext());
        }catch (Exception e){
            throw new IllegalArgumentException("parent activity must implement interface "+TransactionViewMVC.Listener.class);
        }
        initViews();
    }
    public void initViews() {
        swipeRefreshLayout=findViewById(R.id.swiperefresh);
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        for(Listener listener:getListensers())
            listener.onrefresh(swipeRefreshLayout.isRefreshing());
    }
    @Override
    public void setSwiperefreshing(boolean state) {
        swipeRefreshLayout.setRefreshing(state);
    }
}
