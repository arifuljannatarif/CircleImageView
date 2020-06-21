/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.adapters.transaction;

import com.example.mvc.screens.common.views.ObserVableViewMvc;
import com.example.mvc.models.TransactionModel;

public interface TransactionItemViewMvc extends ObserVableViewMvc<TransactionItemViewMvc.Listener> {
    void bindTransaction(TransactionModel item);

    interface Listener{
        void onTransactionClicked(TransactionModel model);
        void addItem(TransactionModel model);

        void performSearch(String key);
    }
}
