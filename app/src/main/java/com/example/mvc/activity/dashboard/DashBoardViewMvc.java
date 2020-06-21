/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.activity.dashboard;
import android.view.MenuItem;

import com.example.mvc._enums.NavigationEvent;
import com.example.mvc._enums.Navigations;
import com.example.mvc.screens.common.views.ObserVableViewMvc;

public interface DashBoardViewMvc extends ObserVableViewMvc<DashBoardViewMvc.Listener> {

    interface Listener  {
        void onDrawerItemSelected(NavigationEvent target);
        boolean onOptionItemSelected(MenuItem item);

        void onFabClicked();

    }
    void toggleDrawer();
    void showProgressbar(boolean state);
}
