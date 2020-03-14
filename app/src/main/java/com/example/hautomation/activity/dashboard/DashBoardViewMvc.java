/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 2/29/20 2:53 PM
 */

package com.example.hautomation.activity.dashboard;
import androidx.appcompat.widget.Toolbar;

import com.example.hautomation._enums.Navigations;
import com.example.hautomation.common.ObserVableViewMvc;
import com.example.hautomation.interfaces.FragmentHandler;

public interface DashBoardViewMvc extends ObserVableViewMvc<DashBoardViewMvc.Listener> {

    interface Listener extends FragmentHandler {
        void onswipeRefresh(boolean isrefreshing);
        void setToolbar(Toolbar toolbar);
        void setToolbarTitle(String title);
        void changeActivity(Navigations target);
    }
    void setSwiperefreshing(boolean b);
    void refresh();
    void showProgressbar(boolean state);
}
