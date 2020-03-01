/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 2/29/20 2:52 PM
 */

package com.example.hautomation.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;

import com.example.hautomation.R;
import com.example.hautomation.fragments.recenttransaction.RecentTransactionFragent;

public class DashBoardActivity extends AppCompatActivity implements DashBoardViewMvc.Listener {
    DashBoardViewMvc viewMvc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewMvc=new DashBoardViewMvcImplementation(LayoutInflater.from(this),null);
        setContentView(viewMvc.getRootView());
    }
    @Override
    protected void onResume() {
        super.onResume();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,new RecentTransactionFragent())
                .commit();
       /* new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(DashBoardActivity.this, TransactionActivity.class));
            }
        },1000);*/
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onswipeRefresh(boolean isrefreshing) {
        viewMvc.showProgressbar(true);
        viewMvc.setSwiperefreshing(false);
        ((RecentTransactionFragent)(getSupportFragmentManager().findFragmentById(R.id.fragment_container))).showProgressbar(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ((RecentTransactionFragent)(getSupportFragmentManager().findFragmentById(R.id.fragment_container))).showProgressbar(false);
                viewMvc.setSwiperefreshing(false);
            }
        },1000);

    }

    @Override
    public void setToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
    }

    @Override
    public void setToolbarTitle(String title) {
        getSupportActionBar().setTitle("Home");
    }

    @Override
    public void fragmentTransaction() {

    }

}
