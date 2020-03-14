/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/7/20 11:23 PM
 */

package com.example.hautomation.fragments.userlist;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.hautomation.R;
import com.example.hautomation._enums.SortyTypes;
import com.example.hautomation.fragments.bottomsheet.addexpense.AddnewExpense;
import com.example.hautomation.fragments.RefreshFragment;

public class UserlistFragent extends RefreshFragment implements UserlistMvc.Listener{
    UserlistMvc mVcView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mVcView=new UserlistMvcImpl(inflater,container);
        try {
            mVcView.registerListener(UserlistFragent.this);
        }catch (Exception e){

            throw new IllegalArgumentException("Your  activity or controller must implement "+ UserlistMvc.Listener.class);
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

    @Override
    public void showSortMenu(View reference) {
        PopupMenu popupMenu=new PopupMenu(getContext(),reference);
        popupMenu.inflate(R.menu.sort_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        popupMenu.show();
        new AddnewExpense().show(getChildFragmentManager(),"add expense");
    }

}
