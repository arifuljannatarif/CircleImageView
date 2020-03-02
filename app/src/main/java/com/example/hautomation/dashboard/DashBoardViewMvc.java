/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 2/29/20 2:53 PM
 */

package com.example.hautomation.dashboard;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import com.example.hautomation._enums.Navigations;
import com.example.hautomation.common.ObserVableViewMvc;
import com.example.hautomation.fragments.recenttransaction.RecentTransactionFragent;

public interface DashBoardViewMvc extends ObserVableViewMvc<DashBoardViewMvc.Listener> {

    interface Listener{
        void onswipeRefresh(boolean isrefreshing);
        void setToolbar(Toolbar toolbar);
        void setToolbarTitle(String title);
        void changeActivity(Navigations target);
        RecentTransactionFragent getCurrentFragment();
    }
    void setSwiperefreshing(boolean b);
    void refresh();
    void showProgressbar(boolean state);
}
