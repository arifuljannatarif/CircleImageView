/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.activity.dashboard;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import com.example.mvc._enums.Navigations;
import com.example.mvc.common.ObserVableViewMvc;
import com.example.mvc.interfaces.FragmentHandler;

public interface DashBoardViewMvc extends ObserVableViewMvc<DashBoardViewMvc.Listener> {

    interface Listener extends FragmentHandler {
        void onswipeRefresh(boolean isrefreshing);
        void setToolbar(Toolbar toolbar);
        void setToolbarTitle(String title);
        void changeActivity(Navigations target);

        boolean onOptionItemSelected(MenuItem item);
    }
    void setSwiperefreshing(boolean b);
    void refresh();
    void showProgressbar(boolean state);
}
