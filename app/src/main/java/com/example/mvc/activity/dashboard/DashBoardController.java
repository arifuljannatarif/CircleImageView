package com.example.mvc.activity.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.mvc.R;
import com.example.mvc._enums.Navigations;
import com.example.mvc.activity.BaseActivity;
import com.example.mvc.activity.profile.Profile;
import com.example.mvc.activity.transactions.TransactionActivity;
import com.example.mvc.fragments.RefreshFragment;
import com.example.mvc.fragments.accounts.AccountsFragment;
import com.example.mvc.fragments.addtransactions.AddTransactionFragment;
import com.example.mvc.fragments.recenttransaction.RecentTransactionFragent;
import com.example.mvc.fragments.userlist.UserlistFragent;

public class DashBoardController implements DashBoardViewMvc.Listener {


    private DashBoardViewMvc viewMvc;
    AppCompatActivity activity;

    public DashBoardController(AppCompatActivity activity){
        this.activity=activity;
    }

    public void  bindView(DashBoardViewMvc viewMvc){
        this.viewMvc = viewMvc;
    }



    @Override
    public void onswipeRefresh(boolean isrefreshing) {
        viewMvc.showProgressbar(true);
        viewMvc.setSwiperefreshing(false);
        getCurrentFragment().showProgressbar(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ((RefreshFragment)(activity.getSupportFragmentManager().findFragmentById(R.id.fragment_container))).showProgressbar(false);
                viewMvc.setSwiperefreshing(false);
            }
        },1000);
    }

    @Override
    public void setToolbar(Toolbar toolbar) {
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
    }

    @Override
    public void setToolbarTitle(String title) {
        activity.getSupportActionBar().setTitle("Home");
    }
    @Override
    public RefreshFragment getCurrentFragment() {
        return  ((RefreshFragment)(activity.getSupportFragmentManager().findFragmentById(R.id.fragment_container)));
    }
    @Override
    public void changeActivity(Navigations target) {
        Intent intent = null;
        switch(target){
            case PROFILE:
                intent=new Intent(viewMvc.getRootView().getContext(), Profile.class);
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
                new AddTransactionFragment(activity, null).show();
                break;
            case ADD_NEW_USER:
                break;
            case TRANSACTIONS:
                intent=new Intent(activity, TransactionActivity.class);
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
            activity.startActivity(intent);
    }

    @Override
    public boolean onOptionItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                return true;
        }
        return false;
    }

    public void onStart() {
        viewMvc.registerListener(this);
        Fragment fragment=new RecentTransactionFragent();
        Bundle bundle=new Bundle();
        bundle.putBoolean(RecentTransactionFragent.SHOW_TOPBAR,true);
        fragment.setArguments(bundle);
        changeFragment(fragment,0, R.id.fragment_container);
    }
    public void  onStop(){
        viewMvc.unregisterListener(this);
    }
    private void changeFragment(final Fragment fragment, int delay, final int containerID) {
        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out);
        fragmentTransaction.replace(containerID, fragment, "tag");
        fragmentTransaction.commitAllowingStateLoss();

    }
}
