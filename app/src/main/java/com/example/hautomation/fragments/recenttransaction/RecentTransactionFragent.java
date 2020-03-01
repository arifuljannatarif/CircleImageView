/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/1/20 8:44 AM
 */

package com.example.hautomation.fragments.recenttransaction;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hautomation._enums.SortyTypes;
import com.example.hautomation.dashboard.DashBoardViewMvc;
import com.example.hautomation.fragments.recenttransaction.RecentTransactionMvc;
import com.example.hautomation.fragments.recenttransaction.RecentTransactionMvcImpl;

public class RecentTransactionFragent extends Fragment implements RecentTransactionMvc.Listener{
    RecentTransactionMvc mVcView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mVcView=new RecentTransactionMvcImpl(inflater,container);
        try {
            mVcView.registerListener(RecentTransactionFragent.this);
        }catch (Exception e){

             throw new IllegalArgumentException("Your  activity or controller must implement "+RecentTransactionMvc.Listener.class);
        }
        return mVcView.getRootView();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Override
    public void refreshTransactions() {

    }

    @Override
    public Void sortTransaction(SortyTypes type) {
        return null;
    }

    @Override
    public void showProgressbar(boolean state) {
        mVcView.showProgressbar(state);
    }

}
