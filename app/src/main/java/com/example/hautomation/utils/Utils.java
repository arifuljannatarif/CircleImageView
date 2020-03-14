/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/8/20 12:29 AM
 */

package com.example.hautomation.utils;

import android.app.Activity;

import com.example.hautomation.R;

public class Utils {
    private final int THEME_DEFAULT=0,THEME_LIGHT=1,THEME_DARK=2;

    public Utils() {
    }

    public void changeTheme(Activity activity,int theme){
        switch (theme){
            case 0:
                activity.setTheme(R.style.AppTheme);
                break;
            case 1:
                activity.setTheme(R.style.AppThemeDark);
                break;
        }
    }
}
