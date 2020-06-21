/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/25/20 1:11 AM
 */

package com.example.mvc.dialogue.confirmdialogue;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mvc.R;
import com.example.mvc.screens.common.views.BaseOvservableViewMvc;

public class ConfirmDialogueMvcImpl extends BaseOvservableViewMvc<ConfirmDialogueMvc.Listener> {
    public ConfirmDialogueMvcImpl(LayoutInflater inflater,ViewGroup parent){
        setRootView(inflater.inflate(R.layout.confirmation_dialog_layout,parent,false));
    }
    @Override
    public void initViews() {

    }


}
