/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.activity.transactions;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mvc.R;
import com.example.mvc.common.BaseOvservableViewMvc;

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
        setupToolbar();
    }

    private void setupToolbar() {
        for(Listener listener:getListensers())
            listener.setUpToolbar((Toolbar) findViewById(R.id.toolbar),"Transaction");
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
