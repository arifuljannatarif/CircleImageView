/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.screens.common.controllers;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvc.common.CustomApplication;
import com.example.mvc.R;
import com.example.mvc.common.dependencyinjection.ControllerCompossionRoot;
import com.example.mvc.screens.fragments.addtransactions.AddTransactionFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BaseActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    protected boolean showFabmenu=false;
    private ControllerCompossionRoot mControllerCompossionRoot;

    protected ControllerCompossionRoot getCompositionRoot(){
        if(mControllerCompossionRoot==null) {
            mControllerCompossionRoot=new ControllerCompossionRoot(
                    ((CustomApplication)getApplication()).getCompositionRoot()
                    ,this);
        }
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
        new AddTransactionFragment(BaseActivity.this, null).show();

    }
}
