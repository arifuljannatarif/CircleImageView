/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/14/20 5:44 PM
 */

package com.example.hautomation.fragments.addtransactions;

import com.example.hautomation.common.ObserVableViewMvc;

public interface AddTransactionMvc extends ObserVableViewMvc<AddTransactionMvc.Listener> {

    public interface Listener {
        void homeBtnPressed();
        void saveButtonClicked();
    }
}
