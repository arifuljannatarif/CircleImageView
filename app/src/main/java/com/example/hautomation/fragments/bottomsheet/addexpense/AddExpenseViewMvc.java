/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/8/20 12:49 AM
 */

package com.example.hautomation.fragments.bottomsheet.addexpense;

import android.graphics.Color;

import com.example.hautomation.common.ObserVableViewMvc;

public interface AddExpenseViewMvc extends ObserVableViewMvc<AddExpenseViewMvc.Listener> {

     interface Listener {
    }
    void changeBackground(int color);
}
