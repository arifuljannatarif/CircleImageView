/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.fragments.addtransactions;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.example.mvc.R;

public class AddTransactionFragment extends Dialog implements AddTransactionMvc.Listener{
    AddTransactionMvcimpl mvcView;

    public AddTransactionFragment(@NonNull Context context,LayoutInflater inflater,ViewGroup container) {
        super(context, R.style.full_screen_dialog);
        mvcView=new AddTransactionMvcimpl(inflater,container);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mvcView.getRootView());
        mvcView.registerListener(this);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
    }

    @Override
    public void homeBtnPressed() {
        dismiss();
    }

    @Override
    public void saveButtonClicked() {
        dismiss();
    }
}
