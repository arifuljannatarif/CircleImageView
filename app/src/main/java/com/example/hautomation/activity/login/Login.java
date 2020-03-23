/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/23/20 12:11 AM
 */

package com.example.hautomation.activity.login;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.hautomation.R;
import com.example.hautomation.activity.dashboard.DashBoardActivity;
import com.example.hautomation.customclasses.FileChooser;
import com.example.hautomation.utils.Utils;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void dashboard(View view) {
        startActivity(new Intent(this, DashBoardActivity.class));
    }
}
