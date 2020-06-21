package com.example.mvc.activity.navigationManager;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mvc.R;
import com.example.mvc._enums.NavigationEvent;
import com.example.mvc.screens.common.controllers.BackPressedListener;
import com.example.mvc.screens.common.navdrawer.BaseNavDrawerViewMvc;
import com.example.mvc.screens.common.screennavigator.ScreensNavigator;
import com.example.mvc.screens.common.views.BaseOvservableViewMvc;

import java.util.HashSet;
import java.util.Set;

public class MainactivityMvcImpl extends BaseNavDrawerViewMvc<NavigationManagerMvc.Listener> {

    public MainactivityMvcImpl(LayoutInflater inflater, ViewGroup parent){
        super(inflater,parent);
        setRootView(inflater.inflate(R.layout.layout_drawer,parent,false));

    }
    @Override
    public void initViews() {}

    @Override
    public void onDraweItemCLicked(NavigationEvent event) {
        super.onDraweItemCLicked(event);
        for(NavigationManagerMvc.Listener listener:getListensers()){
            listener.onDraweItemCLicked(event);
        }
    }
}
