/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.activity.transactions;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;

import com.example.mvc.R;
import com.example.mvc.screens.common.controllers.BaseActivity;
import com.example.mvc.screens.fragments.recenttransaction.RecentTransactionFragent;

public class TransactionActivity extends BaseActivity implements TransactionViewMVC.Listener{
    TransactionViewMVC viewMVC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewMVC=new TransactionImplementation(LayoutInflater.from(this),null);
        setContentView(viewMVC.getRootView());
    }
    @Override
    protected void onStart() {
        super.onStart();
        RecentTransactionFragent fragent=new RecentTransactionFragent();
        Bundle bundle=new Bundle();
        bundle.putBoolean(RecentTransactionFragent.SHOW_TOPBAR,false);
        fragent.setArguments(bundle);
        addFragmentTocontainer(fragent, R.id.fragment_container);
    }
    @Override
    public RecentTransactionFragent getCurrentFragment() {
        return  ((RecentTransactionFragent)(getSupportFragmentManager().findFragmentById(R.id.fragment_container)));
    }
    @Override
    public void addFragmentTocontainer(Fragment fragment, int containerID) {
        getSupportFragmentManager().beginTransaction().replace(containerID,fragment).commit();
    }
    @Override
    public void onrefresh(boolean isrefreshing) {
        getCurrentFragment().showProgressbar(true);
        viewMVC.setSwiperefreshing(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(getCurrentFragment()!=null)
                    getCurrentFragment().showProgressbar(false);
            }
        },3000);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setUpToolbar(Toolbar toolbar, String title) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


}
