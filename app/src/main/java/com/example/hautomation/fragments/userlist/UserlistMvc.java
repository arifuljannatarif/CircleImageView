/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/7/20 11:23 PM
 */

package com.example.hautomation.fragments.userlist;

import android.view.View;

import com.example.hautomation._enums.SortyTypes;
import com.example.hautomation.common.ObserVableViewMvc;

public interface UserlistMvc extends ObserVableViewMvc< UserlistMvc.Listener> {
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
