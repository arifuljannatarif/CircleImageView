/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.screens.fragments.recenttransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mvc.R;
import com.example.mvc._enums.SortyTypes;
import com.example.mvc.screens.common.views.BaseOvservableViewMvc;
import com.example.mvc.adapters.transaction.TransactionRecyclerADapter;
import com.example.mvc.models.TransactionModel;

import java.util.ArrayList;

public class RecentTransactionMvcImpl extends BaseOvservableViewMvc<RecentTransactionMvc.Listener>
        implements RecentTransactionMvc{
    RecyclerView recyclerView;
    TransactionRecyclerADapter recyclerADapter;
    ProgressBar progressBar;
    ImageView sortbtn;
    public RecentTransactionMvcImpl(LayoutInflater inflater, ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.recent_transaction,parent,false));
        initViews();
        initRecycler();
    }

    private void initRecycler() {
        recyclerADapter=new TransactionRecyclerADapter(getContext(),RecentTransactionMvcImpl.this);
        recyclerView.setAdapter(recyclerADapter);
    }
    @Override
    public void initViews() {
        recyclerView=findViewById(R.id.recent_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        progressBar=findViewById(R.id.progressBar);
        sortbtn=findViewById(R.id.recent_sort);
        sortbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Listener listener:getListensers())
                    listener.showSortMenu(sortbtn);
            }
        });
    }
    @Override
    public void showProgressbar(boolean state) {
        if(progressBar!=null)
            progressBar.setVisibility(state? View.VISIBLE:View.GONE);

    }

    @Override
    public void performSearch(String key) {
        recyclerADapter.performSearch(key);
    }

    @Override
    public void sortItems(SortyTypes sortyType, boolean ascending) {

    }

    @Override
    public void updateItems(ArrayList<TransactionModel> list) {
        recyclerADapter.addAll(list);
    }

    @Override
    public void clearAllItem() {
        recyclerADapter.clear();
    }

    @Override
    public void AddItem(TransactionModel model) {
        recyclerADapter.addItem(model);
    }

    @Override
    public void showTopmenu(boolean state) {
        findViewById(R.id.top_bar).setVisibility(state?View.VISIBLE:View.GONE);
    }
}
