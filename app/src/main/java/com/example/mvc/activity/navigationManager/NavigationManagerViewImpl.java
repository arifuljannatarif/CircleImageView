package com.example.mvc.activity.navigationManager;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mvc.R;
import com.example.mvc.common.BaseOvservableViewMvc;

public class NavigationManagerViewImpl extends BaseOvservableViewMvc<NavigationManagerMvc.Listener> {
    public NavigationManagerViewImpl(LayoutInflater inflater, ViewGroup parent){
        setmRootView(inflater.inflate(R.layout.activity_navigation_manager,parent,false));
    }
    @Override
    public void initViews() {}
}
