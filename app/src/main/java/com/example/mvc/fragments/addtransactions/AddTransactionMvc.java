/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.fragments.addtransactions;

import com.example.mvc.common.ObserVableViewMvc;

public interface AddTransactionMvc extends ObserVableViewMvc<AddTransactionMvc.Listener> {

    public interface Listener {
        void homeBtnPressed();
        void saveButtonClicked();
    }
}
