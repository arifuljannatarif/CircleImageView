/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/1/20 8:46 AM
 */

package com.example.hautomation.fragments.recenttransaction;

import android.view.View;

import com.example.hautomation._enums.SortyTypes;
import com.example.hautomation.common.ObserVableViewMvc;
import com.example.hautomation.models.TransactionModel;

import java.util.ArrayList;

public interface RecentTransactionMvc extends ObserVableViewMvc< RecentTransactionMvc.Listener> {
    interface Listener {
        //pass ui interaction to the ui via this listener
        void refreshTransactions();
        Void sortTransaction(SortyTypes type);
        void showProgressbar(boolean state);
        void showSortMenu(View reference);
        void updatingItem(TransactionModel model);
        void showTopmenu(boolean state);
    }
    //write available ui update method here
    void showProgressbar(boolean state);
    void performSearch(String key);
    void sortItems(SortyTypes sortyType,boolean ascending);
    void updateItems(ArrayList<TransactionModel> list);
    void clearAllItem();
    void AddItem(TransactionModel model);
    void showTopmenu(boolean state);
}
