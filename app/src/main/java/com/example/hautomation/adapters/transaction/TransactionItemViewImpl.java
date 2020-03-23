/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/3/20 11:59 AM
 */

package com.example.hautomation.adapters.transaction;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hautomation.R;
import com.example.hautomation.common.BaseOvservableViewMvc;
import com.example.hautomation.models.TransactionModel;

public class TransactionItemViewImpl extends BaseOvservableViewMvc<TransactionItemViewMvc.Listener> implements TransactionItemViewMvc {
    public TransactionItemViewImpl(LayoutInflater inflater, ViewGroup parent, int viewType) {
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
