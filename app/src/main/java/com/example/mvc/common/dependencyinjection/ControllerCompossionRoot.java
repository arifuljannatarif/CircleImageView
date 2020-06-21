/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.common.dependencyinjection;

import android.app.Activity;
import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.mvc.R;
import com.example.mvc.factory.ControllerFactory;
import com.example.mvc.factory.ViewMvcFactory;
import com.example.mvc.screens.common.screennavigator.ScreensNavigator;
import com.example.mvc.screens.common.fragmentframehelper.FragmentFrameHelper;
import com.example.mvc.screens.common.fragmentframehelper.FragmentFrameWrapper;
import com.example.mvc.factory.UseCaseFactory;
import com.google.firebase.firestore.FirebaseFirestore;

public class ControllerCompossionRoot {
    private final CompositionRoot mCompositionroot;
    private final Activity mActivity;
    public ControllerCompossionRoot(CompositionRoot mCompositionroot, FragmentActivity mActivity) {
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

    public FragmentManager getFragmentManager(){
        return ((AppCompatActivity)mActivity).getSupportFragmentManager();
    }
    public ScreensNavigator getScreensNavigator() {
        return new ScreensNavigator(getFragmentFrameHelper());
    }

    private FragmentFrameHelper getFragmentFrameHelper() {
        return new FragmentFrameHelper(getActivity(), getFragmetnConainer(), getFragmentManager());
    }

    private int getFragmetnConainer() {
        return R.id.fragment_container;
    }

    private Activity getActivity() {
        return mActivity;
    }

    public ControllerFactory getControllerFactory() {
        return new ControllerFactory(new UseCaseFactory(), this);
    }
}
