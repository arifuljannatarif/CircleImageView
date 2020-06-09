/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.fragments.recenttransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mvc.R;
import com.example.mvc._enums.SortyTypes;
import com.example.mvc.fragments.bottomsheet.addexpense.AddnewExpense;
import com.example.mvc.fragments.RefreshFragment;
import com.example.mvc.models.TransactionModel;

public class RecentTransactionFragent extends RefreshFragment implements RecentTransactionMvc.Listener{
    RecentTransactionMvc mVcView;
    public static final String SHOW_TOPBAR="topbar";
    boolean showTopbar=false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mVcView=new RecentTransactionMvcImpl(inflater,container);
        try {
            mVcView.registerListener(RecentTransactionFragent.this);
        }catch (Exception e){
            throw new IllegalArgumentException("Your  activity or controller must implement "+RecentTransactionMvc.Listener.class);
        }
        getBundleData(this.getArguments());
        showTopmenu(showTopbar);
        return mVcView.getRootView();
    }
    private void getBundleData(Bundle bundle) {
        Log.d("debugging","retriving "+(bundle==null?"null ":"bundle"));
        if(bundle==null)return;
        showTopbar=bundle.getBoolean(SHOW_TOPBAR,false);
        Log.d("debugging","retriving "+bundle==null?"null ":"bundle "+showTopbar);
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

    @Override
    public void updatingItem(TransactionModel model) {

    }

    @Override
    public void showTopmenu(boolean state) {
        mVcView.showTopmenu(state);
    }

}
