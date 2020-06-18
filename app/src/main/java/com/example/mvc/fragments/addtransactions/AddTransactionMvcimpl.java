/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.fragments.addtransactions;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.example.mvc.R;
import com.example.mvc.common.BaseOvservableViewMvc;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddTransactionMvcimpl extends BaseOvservableViewMvc<AddTransactionMvc.Listener> implements AddTransactionMvc,View.OnClickListener {
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
    public AddTransactionMvcimpl(LayoutInflater inflater, ViewGroup parent) {
        setmRootView(inflater.inflate(R.layout.add_transaction_fragment,parent,false));
        ButterKnife.bind(this,getRootView());
        initViews();
    }
    @Override
    public void initViews() {}
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

}
