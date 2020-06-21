/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.screens.fragments.addtransactions;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvc.R;
import com.example.mvc.adapters.calendar.CalendarRecyclerADapter;
import com.example.mvc.screens.common.views.BaseOvservableViewMvc;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class AddTransactionMvcimpl extends BaseOvservableViewMvc<AddTransactionMvc.Listener> implements AddTransactionMvc,View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    enum EVENT{
        CHANGE_DATE,
        SAVE_TRANSACTION,
        CANCEL_DIALOG,
        PICK_USER,
        UNKNOWN
    }
    public static final String TAG="ADTRANSACTION";

    @BindView(R.id.dateHint)
    TextView dateHint;
    @BindView(R.id.userTv)
    EditText userField;
    @BindView(R.id.notes)
    EditText notesField;
    @BindView(R.id.amount)
    EditText amount;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.dateListRecycler)
    RecyclerView dateRecycler;
    @BindView(R.id.datePickLayout)
    RelativeLayout datePickerLayout;
    @BindView(R.id.paymentContainer)
    ConstraintLayout paymentContainer;
    public AddTransactionMvcimpl(LayoutInflater inflater, ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.add_transaction_fragment,parent,false));
        ButterKnife.bind(this,getRootView());
        initViews();
    }
    @Override
    public void initViews() {
        CalendarRecyclerADapter adapter = new CalendarRecyclerADapter(getContext(), new CalendarRecyclerADapter.Listener() {
            @Override
            public void onDateSelected(CalendarRecyclerADapter.DateModel model) {

            }
        });
        dateRecycler.setAdapter(adapter);
        adapter.updateDay(19);
        dateRecycler.smoothScrollToPosition(19);
    }
    @OnClick({R.id.saveBtn,R.id.up_button,R.id.datePicker,R.id.pickUserBtn})
    public void onClick(View v) {
        AddTransactionMvcimpl.EVENT event;
        switch (v.getId()){
            case R.id.saveBtn:
                event=EVENT.SAVE_TRANSACTION;
                break;
            case R.id.up_button:
                event=EVENT.CANCEL_DIALOG;
                break;
            case R.id.datePicker:
                event=EVENT.CHANGE_DATE;
                break;
            case R.id.pickUserBtn:
                event=EVENT.PICK_USER;
                break;
            default:
                event=EVENT.UNKNOWN;
        }
        for (Listener listener:getListensers()){
            listener.onEvent(event);
        }
    }
    @OnCheckedChanged(R.id.paymentCheckBox)
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        paymentContainer.setVisibility(isChecked?View.VISIBLE:View.GONE);
    }
    @Override
    public void changeDate(String date) {
        dateHint.setText(date);
    }

    @Override
    public void setAmount(String val) {
        amount.setText(val);
    }

    @Override
    public String getAmount() {
        return amount.getText().toString();
    }

    @Override
    public void setAmountError(String error) {
        amount.setError(error);
    }

    @Override
    public void setUserError(String error) {
        userField.setError(error);
    }

    @Override
    public void loadingStatus(boolean state) {
        progressBar.setVisibility(state?View.VISIBLE:View.GONE);
    }

    @Override
    public void toggleDatePicker() {
        if(datePickerLayout.getVisibility()==View.VISIBLE){
            datePickerLayout.setVisibility(View.GONE);
        }else {
            datePickerLayout.setVisibility(View.VISIBLE);

        }
    }
}
