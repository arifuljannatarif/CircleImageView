/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.adapters.userlist;

import com.example.mvc.common.ObserVableViewMvc;
import com.example.mvc.models.TransactionModel;
import com.example.mvc.models.UserModel;

public interface UserlistViewMvc extends ObserVableViewMvc<UserlistViewMvc.Listener> {
    void bindTransaction(TransactionModel item);

    interface Listener{
        void onUserClicked(UserModel model);
    }
}
