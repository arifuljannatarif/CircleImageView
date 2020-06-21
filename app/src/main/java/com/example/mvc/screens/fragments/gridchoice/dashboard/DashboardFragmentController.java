package com.example.mvc.screens.fragments.gridchoice.dashboard;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.mvc.interfaces.ControllerCallBack;

public class DashboardFragmentController implements ControllerCallBack<DashBoardFragmentMvcImpl> {
    private DashBoardFragmentMvcImpl viewMvc;


    @Override
    public void bindView(DashBoardFragmentMvcImpl viewMvc) {
        this.viewMvc = viewMvc;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {}
    @Override
    public void onStart() {}

    @Override
    public void onStop() {}

    @Override
    public void onPause() {}

    @Override
    public void onDestroy() {}
}
