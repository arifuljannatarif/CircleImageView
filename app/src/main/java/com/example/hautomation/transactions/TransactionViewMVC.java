/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 2/29/20 11:33 AM
 */

package com.example.hautomation.transactions;

import com.example.hautomation.common.ObserVableViewMvc;

interface TransactionViewMVC extends ObserVableViewMvc<TransactionRecyclerADapter.ItemClickListener> {
    void showProgressbar(boolean state);
    void showitems(boolean b);
}
