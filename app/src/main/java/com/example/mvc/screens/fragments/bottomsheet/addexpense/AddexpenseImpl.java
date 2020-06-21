/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.screens.fragments.bottomsheet.addexpense;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.mvc.R;
import com.example.mvc._enums.ExpenseCatagory;
import com.example.mvc._enums.TransactionMode;
import com.example.mvc._enums.TransactionType;
import com.example.mvc.screens.common.views.BaseOvservableViewMvc;

public class AddexpenseImpl extends BaseOvservableViewMvc<AddExpenseViewMvc.Listener>
        implements AddExpenseViewMvc  {
    Spinner typeSpinner,catagorySpinner,modeSpinner;
    View mainView;
    public AddexpenseImpl(LayoutInflater inflater, ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.add_expense_bottomsheet,parent,false));
        //initViews();
    }

    @Override
    public void initViews() {
        mainView=findViewById(R.id.main_view);
        typeSpinner=findViewById(R.id.dateHint);
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
