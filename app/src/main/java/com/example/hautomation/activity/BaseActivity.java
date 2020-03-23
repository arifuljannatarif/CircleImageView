/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/21/20 8:21 PM
 */

package com.example.hautomation.activity;

import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hautomation.CustomApplication;
import com.example.hautomation.R;
import com.example.hautomation.common.dependencyinjection.ControllerCompossionRoot;
import com.example.hautomation.fragments.addtransactions.AddTransactionFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BaseActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    protected boolean showFabmenu=false;
    private ControllerCompossionRoot mControllerCompossionRoot;

    protected ControllerCompossionRoot getCompositionRoot(){
        if(mControllerCompossionRoot==null)
            mControllerCompossionRoot=new ControllerCompossionRoot(
                    ((CustomApplication)getApplication()).getmCompositionRoot()
            ,this);
        return mControllerCompossionRoot;
    }
    @Override
    protected void onStart() {
        super.onStart();
        floatingActionButton=findViewById(R.id.fab);
        if(floatingActionButton!=null && showFabmenu){
            floatingActionButton.setVisibility(View.VISIBLE);
            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onfabClicked();
                }
            });
        }
    }
    protected void onfabClicked(){
        new AddTransactionFragment(BaseActivity.this, LayoutInflater.from(BaseActivity.this),null)
                .show();
    }
}
