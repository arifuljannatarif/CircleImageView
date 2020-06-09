/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.activity.transactions;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.mvc.common.ObserVableViewMvc;
import com.example.mvc.fragments.recenttransaction.RecentTransactionFragent;

interface TransactionViewMVC extends ObserVableViewMvc<TransactionViewMVC.Listener> {
    interface Listener{
        void addFragmentTocontainer(Fragment fragment,int containerID);
        RecentTransactionFragent getCurrentFragment();
        void onrefresh(boolean isrefreshing);
        void setUpToolbar(Toolbar toolbar, String title);
    }
    void setSwiperefreshing(boolean b);
}
