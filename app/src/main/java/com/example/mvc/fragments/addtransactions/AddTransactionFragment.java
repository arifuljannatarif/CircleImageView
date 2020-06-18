/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.fragments.addtransactions;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mvc.R;

public class AddTransactionFragment extends Dialog{
    AddTransactionFragmentController controller;
    public AddTransactionFragment(Context activity, ViewGroup container) {
        super(activity, R.style.full_screen_dialog);
        controller=new AddTransactionFragmentController();
        controller.bindView(new AddTransactionMvcimpl(LayoutInflater.from(activity),container));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(controller.geViewMvc().getRootView());
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
        controller.setDialog(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        controller.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        controller.onStart();
    }
}
