package com.example.mvc.activity.navigationManager;

import android.os.Bundle;

import com.example.mvc.R;
import com.example.mvc.activity.BaseActivity;

public class NavigationManagerActivity extends BaseActivity {
    NavigationManagerController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NavigationManagerViewImpl mvc=getCompositionRoot().getViewMvcFactory().geNavigationActivityViewMvc(null);
        controller=getCompositionRoot().getControllerFactory().geNavigationManagerActivityController();
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
}