/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/3/20 11:53 AM
 */

package com.example.hautomation.adapters.transaction;

import com.example.hautomation.common.ObserVableViewMvc;
import com.example.hautomation.models.TransactionModel;

public interface TransactionItemViewMvc extends ObserVableViewMvc<TransactionItemViewMvc.Listener> {
    void bindTransaction(TransactionModel item);

    interface Listener{
        void onTransactionClicked(TransactionModel model);
        void addItem(TransactionModel model);

        void performSearch(String key);
    }
}
