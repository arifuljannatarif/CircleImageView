/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.screens.fragments.accounts;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mvc.R;
import com.example.mvc.screens.common.views.BaseOvservableViewMvc;

public class AccountFragmentMvcImpl extends BaseOvservableViewMvc<AccountFragmentMvc.Listener> implements AccountFragmentMvc {
    AccountFragmentMvcImpl mvc;

    public AccountFragmentMvcImpl(LayoutInflater inflater, ViewGroup container) {
        setRootView(inflater.inflate(R.layout.account_fragment_layout,container,false));
        initViews();
    }
    @Override
    public void initViews() {

    }

}
