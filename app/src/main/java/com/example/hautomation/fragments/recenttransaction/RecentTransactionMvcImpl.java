/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/1/20 8:46 AM
 */

package com.example.hautomation.fragments.recenttransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hautomation.R;
import com.example.hautomation.common.BaseOvservableViewMvc;
import com.example.hautomation.transactions.TransactionRecyclerADapter;

public class RecentTransactionMvcImpl extends BaseOvservableViewMvc<RecentTransactionMvc.Listener>
        implements RecentTransactionMvc,TransactionRecyclerADapter.ItemClickListener{
    RecyclerView recyclerView;
    TransactionRecyclerADapter recyclerADapter;
    ProgressBar progressBar;
    public RecentTransactionMvcImpl(LayoutInflater inflater, ViewGroup parent) {
        setmRootView(inflater.inflate(R.layout.recent_transaction,parent,false));
        initViews();
    }

    @Override
    public void initViews() {
        recyclerView=findViewById(R.id.recent_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerADapter=new TransactionRecyclerADapter(getContext(),RecentTransactionMvcImpl.this);
        recyclerView.setAdapter(recyclerADapter);
        progressBar=findViewById(R.id.progressBar);
    }

    @Override
    public void onItemClick(int pos) {
        Toast.makeText(getContext(),"Item clicked",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressbar(boolean state) {
        if(progressBar!=null)
            progressBar.setVisibility(state? View.VISIBLE:View.GONE);

    }
}
