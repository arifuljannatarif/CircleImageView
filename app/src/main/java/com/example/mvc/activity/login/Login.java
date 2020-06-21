/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mvc.R;
import com.example.mvc.screens.common.controllers.BaseActivity;
import com.example.mvc.activity.dashboard.DashBoardActivity;

public class Login extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //new Utils().changeTheme(this,new SharedPreferencesManager(this).retrieveInt("theme",1));
        setContentView(R.layout.activity_login);
    }
    public void dashboard(View view) {
        findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
        startActivity(new Intent(Login.this, DashBoardActivity.class));
        finish();
    }
}
