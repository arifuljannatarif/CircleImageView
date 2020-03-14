/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/7/20 9:06 AM
 */

package com.example.hautomation.fragments.bottomsheet.addexpense;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.hautomation.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class AddnewExpense extends BottomSheetDialogFragment implements AddExpenseViewMvc.Listener{
    public static final String EXTRA_MODEL = "model";
    AddExpenseViewMvc mvcView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.bottosheetTheme);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mvcView=new AddexpenseViewMvcImpl(inflater,container);
        mvcView.registerListener(this);
        return mvcView.getRootView();
    }


}
