/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/2/20 9:06 PM
 */

package com.example.hautomation.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.example.hautomation.common.BaseActivity;


public class Profile extends BaseActivity implements ProfileMvc.Listener {
    ProfileMvcImpl mMvcView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMvcView =new ProfileMvcImpl(LayoutInflater.from(this),null);
        setContentView(mMvcView.getRootView());
    }
    @Override
    public void setupToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public void setToolbarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
