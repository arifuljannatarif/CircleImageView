/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/14/20 5:43 PM
 */

package com.example.hautomation.fragments.addtransactions;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hautomation.R;

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
