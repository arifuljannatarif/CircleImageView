/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.screens.fragments.bottomsheet.addexpense;

import com.example.mvc.screens.common.views.ObserVableViewMvc;

public interface AddExpenseViewMvc extends ObserVableViewMvc<AddExpenseViewMvc.Listener> {

     interface Listener {
    }
    void changeBackground(int color);
}
