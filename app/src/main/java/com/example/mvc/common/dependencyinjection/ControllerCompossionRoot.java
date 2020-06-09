/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.common.dependencyinjection;

import android.app.Activity;
import android.view.LayoutInflater;

import com.example.mvc.activity.homepage.HomePageActivityController;
import com.example.mvc.common.ControllerFactory;
import com.example.mvc.common.ViewMvcFactory;
import com.google.firebase.firestore.FirebaseFirestore;

public class ControllerCompossionRoot {
    private final CompositionRoot mCompositionroot;
    private final Activity mActivity;

    public ControllerCompossionRoot(CompositionRoot mCompositionroot, Activity mActivity) {
        this.mCompositionroot = mCompositionroot;
        this.mActivity = mActivity;
    }

    public FirebaseFirestore getFirestore() {
        return mCompositionroot.getFirestoreInstance();
    }
    private LayoutInflater getLayoutinflater(){
        return LayoutInflater.from(mActivity);
    }

    public ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(getLayoutinflater());
    }

    public HomePageActivityController geHomePageActivityController() {
        return new HomePageActivityController();
    }

    public ControllerFactory geControllerFactory() {
        return new ControllerFactory();
    }
}
