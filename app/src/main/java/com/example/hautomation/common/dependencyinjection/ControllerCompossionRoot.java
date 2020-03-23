/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/19/20 12:39 PM
 */

package com.example.hautomation.common.dependencyinjection;

import android.app.Activity;
import android.view.LayoutInflater;

import com.example.hautomation.activity.dashboard.DashBoardViewMvc;
import com.example.hautomation.common.ViewMvcFactory;
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
}
