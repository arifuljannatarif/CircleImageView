/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.fragments.addtransactions;

import com.example.mvc.common.ObserVableViewMvc;

public interface AddTransactionMvc extends ObserVableViewMvc<AddTransactionMvc.Listener> {

    public interface Listener {
        void homeBtnPressed();
        void saveButtonClicked();
        void onEvent(AddTransactionMvcimpl.EVENT event);
    }
    void changeDate(String date);
    void setAmount(String val);
    String  getAmount();
    void setAmountError(String error);
    void setUserError(String error);
    void loadingStatus(boolean state);
}
