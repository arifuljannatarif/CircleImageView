/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.adapters.transaction;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mvc.R;
import com.example.mvc.screens.common.views.BaseOvservableViewMvc;
import com.example.mvc.models.TransactionModel;

import javax.annotation.Nullable;

public class TransactionItemViewMvcImpl extends BaseOvservableViewMvc<TransactionItemViewMvc.Listener> implements TransactionItemViewMvc {
    public TransactionItemViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent, int viewType) {
        if(viewType==TransactionRecyclerADapter.TYPE_DATE)
            setRootView(inflater.inflate(R.layout.transaction_date_item,parent,false));
        else
            setRootView(inflater.inflate(R.layout.recent_transaction_item,parent,false));
        initViews();
    }
    @Override
    public void initViews() {

    }

    @Override
    public void bindTransaction(TransactionModel item) {

    }
}
