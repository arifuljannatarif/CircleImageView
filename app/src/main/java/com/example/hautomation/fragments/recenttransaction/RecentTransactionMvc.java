/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/1/20 8:46 AM
 */

package com.example.hautomation.fragments.recenttransaction;

import com.example.hautomation._enums.SortyTypes;
import com.example.hautomation.common.ObserVableViewMvc;

public interface RecentTransactionMvc extends ObserVableViewMvc< RecentTransactionMvc.Listener> {
    interface Listener {
        //pass ui interaction to the ui via this listener
        public void refreshTransactions();
        public Void sortTransaction(SortyTypes type);
        public void showProgressbar(boolean state);
    }
    //write available ui update method here
    public void showProgressbar(boolean state);
}
