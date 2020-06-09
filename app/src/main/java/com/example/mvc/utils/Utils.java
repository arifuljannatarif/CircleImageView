/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;

import com.example.mvc.R;

public class Utils {
    private final int THEME_DEFAULT=0,THEME_LIGHT=1,THEME_DARK=2;

    public Utils() {
    }

    public void changeTheme(Activity activity,int theme){
        switch (theme){
            case THEME_DEFAULT:
                activity.setTheme(R.style.AppTheme);
                break;
            case THEME_LIGHT:
                activity.setTheme(R.style.AppThemeDark);
                break;
        }
    }
    public boolean checkAndRequestStoragePermission(Activity activity){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && activity.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE}, 112);
            return false;
        }

        return true;
    }
}
