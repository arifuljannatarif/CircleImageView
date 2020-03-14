/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/7/20 11:25 PM
 */

package com.example.hautomation.adapters.userlist;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hautomation.R;
import com.example.hautomation.common.BaseOvservableViewMvc;
import com.example.hautomation.models.TransactionModel;

public class UserlistViewImpl extends BaseOvservableViewMvc<UserlistViewMvc.Listener> implements UserlistViewMvc {
    public UserlistViewImpl(LayoutInflater inflater, ViewGroup parent, int viewType) {
        setmRootView(inflater.inflate(R.layout.user_list_item,parent,false));
        initViews();
    }
    @Override
    public void initViews() {

    }

    @Override
    public void bindTransaction(TransactionModel item) {

    }
}
