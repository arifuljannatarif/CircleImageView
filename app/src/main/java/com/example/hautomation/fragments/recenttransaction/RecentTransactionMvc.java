/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/1/20 8:46 AM
 */

package com.example.hautomation.fragments.recenttransaction;

import android.view.View;

import com.example.hautomation._enums.SortyTypes;
import com.example.hautomation.common.ObserVableViewMvc;

public interface RecentTransactionMvc extends ObserVableViewMvc< RecentTransactionMvc.Listener> {
    interface Listener {
        //pass ui interaction to the ui via this listener
         void refreshTransactions();
         Void sortTransaction(SortyTypes type);
         void showProgressbar(boolean state);
        void showSortMenu(View reference);
    }
    //write available ui update method here
    public void showProgressbar(boolean state);
}
