/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.adapters.transaction;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mvc.R;
import com.example.mvc.common.BaseOvservableViewMvc;
import com.example.mvc.models.TransactionModel;

import javax.annotation.Nullable;

public class TransactionItemViewImpl extends BaseOvservableViewMvc<TransactionItemViewMvc.Listener> implements TransactionItemViewMvc {
    public TransactionItemViewImpl(LayoutInflater inflater, @Nullable ViewGroup parent, int viewType) {
        if(viewType==TransactionRecyclerADapter.TYPE_DATE)
            setmRootView(inflater.inflate(R.layout.transaction_date_item,parent,false));
        else
            setmRootView(inflater.inflate(R.layout.recent_transaction_item,parent,false));
        initViews();
    }
    @Override
    public void initViews() {

    }

    @Override
    public void bindTransaction(TransactionModel item) {

    }
}
