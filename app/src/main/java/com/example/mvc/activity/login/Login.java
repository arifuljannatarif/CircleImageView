/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.activity.login;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.mvc.R;
import com.example.mvc.activity.BaseActivity;
import com.example.mvc.activity.dashboard.DashBoardActivity;
import com.example.mvc.dialogue.confirmdialogue.ConfirmationDialogue;
import com.example.mvc.utils.SharedPreferencesManager;
import com.example.mvc.utils.Utils;

public class Login extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Utils().changeTheme(this,new SharedPreferencesManager(this).retrieveInt("theme",1));
        setContentView(R.layout.activity_login);
    }
    public void dashboard(View view) {
    //    new ConfirmationDialogue(Login.this).show();
        findViewById(R.id.progressbar).setVisibility(View.VISIBLE);
        startActivity(new Intent(Login.this, DashBoardActivity.class));
        findViewById(R.id.progressbar).setVisibility(View.GONE);
       /* findViewById(R.id.progressbar).setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                running=false;
                findViewById(R.id.progressbar).setVisibility(View.GONE);

            }
        },5000);*/
    }
}
