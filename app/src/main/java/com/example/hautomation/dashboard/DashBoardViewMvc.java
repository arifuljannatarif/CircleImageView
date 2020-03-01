/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 2/29/20 2:53 PM
 */

package com.example.hautomation.dashboard;
import androidx.appcompat.widget.Toolbar;

import com.example.hautomation.common.ObserVableViewMvc;

public interface DashBoardViewMvc extends ObserVableViewMvc<DashBoardViewMvc.Listener> {

    interface Listener{
        void onswipeRefresh(boolean isrefreshing);
        void setToolbar(Toolbar toolbar);
        void setToolbarTitle(String title);
        void fragmentTransaction();
    }
    void setSwiperefreshing(boolean b);
    void refresh();
    void showProgressbar(boolean state);
}
