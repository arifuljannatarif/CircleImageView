/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.screens.common.views;

import android.content.Context;
import android.view.View;

public abstract class BaseViewMvc implements ViewMvc {
    private View mRootView;
    @Override
    public View getRootView() {
        return mRootView;
    }
    protected void setRootView(View mRootView) {
        this.mRootView = mRootView;
    }
    protected   <T extends View> T findViewById(int id) {
        return getRootView().findViewById(id);
    }
    protected Context getContext() {
        return getRootView().getContext();
    }
}
