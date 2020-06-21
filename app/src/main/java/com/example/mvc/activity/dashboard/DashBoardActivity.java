/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.activity.dashboard;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.example.mvc.R;
import com.example.mvc.screens.common.controllers.BaseActivity;

public class DashBoardActivity extends BaseActivity{
    DashBoardController dashBoardController;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // new Utils().changeTheme(this,new SharedPreferencesManager(this).retrieveInt("theme",1));
        DashBoardViewImpl viewMvc = getCompositionRoot().getViewMvcFactory().getDashboardViewMvc(null);
        dashBoardController =getCompositionRoot().getControllerFactory( ).getDashBoardActivityController(this);
        dashBoardController.bindView(viewMvc);
        setContentView(viewMvc.getRootView());
        super.showFabmenu=true;
    }
    @Override
    public void onStart() {
        super.onStart();
        dashBoardController.onStart();

    }

    @Override
    protected void onfabClicked() {
        dashBoardController.onFabClicked();
    }

    @Override
    protected void onStop() {
        super.onStop();
        dashBoardController.onStop();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(dashBoardController.onOptionItemSelected(item))
            return true;
        else  return  super.onOptionsItemSelected(item);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dashboard_menu,menu);
        return true;
    }


}
