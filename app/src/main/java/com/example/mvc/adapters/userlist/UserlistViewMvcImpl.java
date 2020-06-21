/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.adapters.userlist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mvc.R;
import com.example.mvc.screens.common.views.BaseOvservableViewMvc;
import com.example.mvc.models.TransactionModel;

public class UserlistViewMvcImpl extends BaseOvservableViewMvc<UserlistViewMvc.Listener> implements UserlistViewMvc {
    public UserlistViewMvcImpl(LayoutInflater inflater, ViewGroup parent, int viewType) {
        setRootView(inflater.inflate(R.layout.user_list_item,parent,false));
        initViews();
    }
    @Override
    public void initViews() {

    }

    @Override
    public void bindTransaction(TransactionModel item) {

    }
}
