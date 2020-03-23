/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/19/20 12:18 PM
 */

package com.example.hautomation;

import android.app.Application;

import com.example.hautomation.common.dependencyinjection.CompositionRoot;

public class CustomApplication extends Application {
    private CompositionRoot mCompositionRoot;

    @Override
    public void onCreate() {
        super.onCreate();
        mCompositionRoot=new CompositionRoot();
    }

    public CompositionRoot getmCompositionRoot() {
        return mCompositionRoot;
    }
}
