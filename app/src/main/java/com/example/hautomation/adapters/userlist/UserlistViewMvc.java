/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/7/20 11:25 PM
 */

package com.example.hautomation.adapters.userlist;

import com.example.hautomation.common.ObserVableViewMvc;
import com.example.hautomation.interfaces.RefreshMethods;
import com.example.hautomation.models.TransactionModel;
import com.example.hautomation.models.UserModel;

public interface UserlistViewMvc extends ObserVableViewMvc<UserlistViewMvc.Listener> {
    void bindTransaction(TransactionModel item);

    interface Listener{
        void onUserClicked(UserModel model);
    }
}
