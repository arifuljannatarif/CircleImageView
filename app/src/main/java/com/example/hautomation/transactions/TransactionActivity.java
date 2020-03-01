/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 2/29/20 10:49 AM
 */

package com.example.hautomation.transactions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.example.hautomation.common.BaseActivity;

import java.util.TimerTask;

public class TransactionActivity extends BaseActivity implements TransactionRecyclerADapter.ItemClickListener {
    TransactionViewMVC viewMVC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewMVC=new TransactionViewMVCImplementation(LayoutInflater.from(this),null);
        viewMVC.registerListener(this);
        setContentView(viewMVC.getRootView());
    }
    @Override
    protected void onStart() {
        super.onStart();
        fetchItems();
    }
    private void fetchItems() {
        viewMVC.showProgressbar(true);
        viewMVC.showitems(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                viewMVC.showProgressbar(false);
                viewMVC.showitems(true);
            }
        },10000);
    }

    @Override
    public void onItemClick(int pos) {
        Toast.makeText(this,"Item clicked "+pos,Toast.LENGTH_SHORT).show();
    }
}
