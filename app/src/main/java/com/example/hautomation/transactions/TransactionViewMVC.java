/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 2/29/20 11:33 AM
 */

package com.example.hautomation.transactions;

import androidx.fragment.app.Fragment;

import com.example.hautomation.common.ObserVableViewMvc;
import com.example.hautomation.dashboard.DashBoardViewMvc;
import com.example.hautomation.fragments.recenttransaction.RecentTransactionFragent;

interface TransactionViewMVC extends ObserVableViewMvc<TransactionViewMVC.Listener> {
    interface Listener{
        void addFragmentTocontainer(Fragment fragment,int containerID);
        RecentTransactionFragent getCurrentFragment();
        void onrefresh(boolean isrefreshing);
    }
    void setSwiperefreshing(boolean b);
}
