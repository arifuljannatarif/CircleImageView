/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.screens.fragments.gridchoice.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvc.screens.common.views.BaseOvservableViewMvc;
import com.example.mvc.databinding.DashboardBinding;

public class DashBoardFragmentMvcImpl extends BaseOvservableViewMvc<DashBoardFragmentMvc.Listener> implements DashBoardFragmentMvc {
    DashboardBinding binding;

    public DashBoardFragmentMvcImpl(LayoutInflater inflater, ViewGroup container) {
        binding=DashboardBinding.inflate(inflater,container,false);
        setRootView(binding.getRoot());
        initViews();
    }
    @Override
    public void initViews() {
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
