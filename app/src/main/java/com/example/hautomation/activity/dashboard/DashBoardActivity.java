/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 2/29/20 2:52 PM
 */

package com.example.hautomation.activity.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hautomation.R;
import com.example.hautomation._enums.Navigations;
import com.example.hautomation.fragments.accounts.AccountsFragment;
import com.example.hautomation.activity.BaseActivity;
import com.example.hautomation.fragments.RefreshFragment;
import com.example.hautomation.fragments.addtransactions.AddTransactionFragment;
import com.example.hautomation.fragments.recenttransaction.RecentTransactionFragent;
import com.example.hautomation.fragments.userlist.UserlistFragent;
import com.example.hautomation.activity.profile.Profile;
import com.example.hautomation.activity.transactions.TransactionActivity;
import com.example.hautomation.utils.SharedPreferencesManager;
import com.example.hautomation.utils.Utils;

public class DashBoardActivity extends BaseActivity implements DashBoardViewMvc.Listener {
    DashBoardViewMvc viewMvc;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Utils().changeTheme(this,new SharedPreferencesManager(this).retrieveInt("theme",1));
        viewMvc=getCompositionRoot().getViewMvcFactory().getDashboardViewMvc(null);
        setContentView(viewMvc.getRootView());
        super.showFabmenu=true;
    }
    @Override
    public void onStart() {
        super.onStart();
        Fragment fragment=new RecentTransactionFragent();
        Bundle bundle=new Bundle();
        bundle.putBoolean(RecentTransactionFragent.SHOW_TOPBAR,true);
        fragment.setArguments(bundle);
        changeFragment(fragment,0,R.id.fragment_container);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public RefreshFragment getCurrentFragment() {
        return  ((RefreshFragment)(getSupportFragmentManager().findFragmentById(R.id.fragment_container)));
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
        getCurrentFragment().showProgressbar(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ((RefreshFragment)(getSupportFragmentManager().findFragmentById(R.id.fragment_container))).showProgressbar(false);
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
    public void changeActivity(Navigations target) {
        Intent intent = null;
        switch(target){
            case PROFILE:
                intent=new Intent(this, Profile.class);
                break;
            case DASHBOARD:
                break;
            case LOGOUT:
                break;
            case ACCOUNTS:
                changeFragment(new AccountsFragment(),250,R.id.fragment_container);
                break;
            case CATAGORIES:
                break;
            case ADD_TRANSACTION:
                new AddTransactionFragment(viewMvc.getRootView().getContext(),LayoutInflater.from(DashBoardActivity.this),null).show();
                break;
            case ADD_NEW_USER:
                break;
            case TRANSACTIONS:
                intent=new Intent(this,TransactionActivity.class);
                break;
            case USER_LIST:
                changeFragment(new UserlistFragent(),250,R.id.fragment_container);
                break;
            case HOME:
                Fragment fragment=new RecentTransactionFragent();
                Bundle bundle=new Bundle();
                bundle.putBoolean(RecentTransactionFragent.SHOW_TOPBAR,false);
                fragment.setArguments(bundle);
                changeFragment(fragment,250,R.id.fragment_container);
                break;
        }
        if(intent!=null)
            this.startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dashboard_menu,menu);
        return true;
    }

    private void changeFragment(final Fragment fragment, int delay, final int containerID) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out);
        fragmentTransaction.replace(containerID, fragment, "tag");
        fragmentTransaction.commitAllowingStateLoss();

       /* Handler  mHandler = new Handler();
        delay=0;
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.fragment_container, fragment, "tag");
                fragmentTransaction.commitAllowingStateLoss();
            }
        };
        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.postDelayed(mPendingRunnable,delay);
        }*/
    }

}
