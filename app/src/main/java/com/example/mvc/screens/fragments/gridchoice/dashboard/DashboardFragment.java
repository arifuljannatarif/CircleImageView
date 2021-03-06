/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.screens.fragments.gridchoice.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mvc.screens.fragments.RefreshFragment;

public class DashboardFragment extends RefreshFragment implements DashBoardFragmentMvc.Listener {

    DashboardFragmentController controller;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //  mvcView=mvcFactory.getAccountFragmentMvc(container);
        DashBoardFragmentMvcImpl mvcView = new DashBoardFragmentMvcImpl(inflater, container);
        mvcView.registerListener(this);
        controller=getControllerFactory().getDashBoardFragmetnController();
        controller.bindView(mvcView);
        return mvcView.getRootView();
    }

    @Override
    public void showProgressbar(boolean state) {

    }

    @Override
    public void onStop() {
        super.onStop();
        controller.onStop();

    }

    @Override
    public void onStart() {
        super.onStart();
        controller.onStop();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        controller.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        controller.onPause();
    }

}
