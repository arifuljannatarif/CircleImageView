/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 2/29/20 10:49 AM
 */

package com.example.hautomation.transactions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.example.hautomation.R;
import com.example.hautomation.common.BaseActivity;
import com.example.hautomation.fragments.recenttransaction.RecentTransactionFragent;

import java.util.TimerTask;

public class TransactionActivity extends BaseActivity implements TransactionViewMVC.Listener{
    TransactionViewMVC viewMVC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewMVC=new TransactionViewMVCImplementation(LayoutInflater.from(this),null);
        setContentView(viewMVC.getRootView());
    }
    @Override
    protected void onStart() {
        super.onStart();
        addFragmentTocontainer(new RecentTransactionFragent(), R.id.fragment_container);
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
                getCurrentFragment().showProgressbar(false);
            }
        },3000);

    }
}
