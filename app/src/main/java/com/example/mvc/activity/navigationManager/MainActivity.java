package com.example.mvc.activity.navigationManager;

import android.os.Bundle;

import com.example.mvc.screens.common.controllers.BaseActivity;

public class MainActivity extends BaseActivity {

    MainActivityController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainactivityMvcImpl mvc=getCompositionRoot().getViewMvcFactory().geNavigationActivityViewMvc(null);
        controller=getCompositionRoot().getControllerFactory().geNavigationManagerActivityController(this);
        controller.bindView(mvc);
        setContentView(mvc.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        controller.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        controller.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}