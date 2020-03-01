/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 2/29/20 12:00 PM
 */

package com.example.hautomation.common;

import android.content.Context;
import android.view.View;

public abstract class BaseViewMvc implements ViewMvc{
    private View mRootView;
    @Override
    public View getRootView() {
        return mRootView;
    }
    public void setmRootView(View mRootView) {
        this.mRootView = mRootView;
    }

    protected   <T extends View> T findViewById(int id) {
        return getRootView().findViewById(id);
    }
    protected Context getContext() {
        return getRootView().getContext();
    }
}
