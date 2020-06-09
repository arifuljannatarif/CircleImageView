/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.fragments.addtransactions;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.example.mvc.R;
import com.example.mvc.common.BaseOvservableViewMvc;

import java.util.ArrayList;
import java.util.List;

public class AddTransactionMvcimpl extends BaseOvservableViewMvc<AddTransactionMvc.Listener> implements AddTransactionMvc {
    public AddTransactionMvcimpl(LayoutInflater inflater, ViewGroup parent) {
        setmRootView(inflater.inflate(R.layout.add_transaction_fragment,parent,false));
        initViews();
    }
    @Override
    public void initViews() {
        findViewById(R.id.up_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Listener listener:getListensers())
                    listener.homeBtnPressed();
            }
        });
        findViewById(R.id.save_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Listener listener:getListensers())
                    listener.saveButtonClicked();
            }
        });
        findViewById(R.id.add_sel_catagory).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });
    }
    private void showAlertDialog() {
        // Prepare grid view
        GridView gridView = new GridView(getContext());

        List<String> mList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            mList.add(i+"");
        }

        gridView.setAdapter(new ArrayAdapter(getContext(), R.layout.category_item, mList){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if(convertView==null)
                    convertView=LayoutInflater.from(getContext()).inflate(R.layout.category_item,parent,false);
                ((TextView)convertView).setCompoundDrawablesRelativeWithIntrinsicBounds(0,R.drawable.ic_arrow_drop_down_black_24dp,0,0);
                ((TextView) convertView).setText((CharSequence) getItem(position));
                return convertView;
            }
        });

         AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        gridView.setNumColumns(3);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        // Set grid view to alertDialog
        builder.setView(gridView);
        builder.setTitle("Select Catagory");
        builder.show();
    }
}
