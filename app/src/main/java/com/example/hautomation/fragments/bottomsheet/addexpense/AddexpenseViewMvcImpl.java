/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/8/20 12:49 AM
 */

package com.example.hautomation.fragments.bottomsheet.addexpense;

import android.content.res.TypedArray;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.hautomation.R;
import com.example.hautomation._enums.ExpenseCatagory;
import com.example.hautomation._enums.TransactionMode;
import com.example.hautomation._enums.TransactionType;
import com.example.hautomation.common.BaseOvservableViewMvc;

public class AddexpenseViewMvcImpl extends BaseOvservableViewMvc<AddExpenseViewMvc.Listener>
        implements AddExpenseViewMvc  {
    Spinner typeSpinner,catagorySpinner,modeSpinner;
    View mainView;
    public AddexpenseViewMvcImpl(LayoutInflater inflater, ViewGroup parent) {
        setmRootView(inflater.inflate(R.layout.add_expense_bottomsheet,parent,false));
        initViews();
    }

    @Override
    public void initViews() {
        mainView=findViewById(R.id.main_view);
        typeSpinner=findViewById(R.id.type);
        typeSpinner.setAdapter(new ArrayAdapter<TransactionType>(getContext(),android.R.layout.simple_spinner_dropdown_item, TransactionType.values()));
        modeSpinner=findViewById(R.id.mode);
        modeSpinner.setAdapter(new ArrayAdapter<TransactionMode>(getContext(),android.R.layout.simple_spinner_dropdown_item, TransactionMode.values()));
        catagorySpinner=findViewById(R.id.catagory);
        catagorySpinner.setAdapter(new ArrayAdapter<ExpenseCatagory>(getContext(),android.R.layout.simple_spinner_dropdown_item, ExpenseCatagory.values()));
    }

    @Override
    public void changeBackground(int color) {
        //mainView.getBackground().setTint(color);
    }
}
