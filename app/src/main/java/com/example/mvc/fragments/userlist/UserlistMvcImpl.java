/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.fragments.userlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvc.R;
import com.example.mvc.adapters.userlist.UserlistRecyclerADapter;
import com.example.mvc.common.BaseOvservableViewMvc;

public class UserlistMvcImpl extends BaseOvservableViewMvc<UserlistMvc.Listener>
        implements UserlistMvc {
    RecyclerView recyclerView;
    UserlistRecyclerADapter recyclerADapter;
    ProgressBar progressBar;
    ImageView sortbtn;
    public UserlistMvcImpl(LayoutInflater inflater, ViewGroup parent) {
        setmRootView(inflater.inflate(R.layout.recent_transaction,parent,false));
        initViews();
        initRecycler();
    }

    private void initRecycler() {
        recyclerADapter=new UserlistRecyclerADapter(getContext(), UserlistMvcImpl.this);
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
}
