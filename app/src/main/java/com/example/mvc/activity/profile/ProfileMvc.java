/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.activity.profile;

import androidx.appcompat.widget.Toolbar;

import com.example.mvc.screens.common.views.ObserVableViewMvc;

public interface ProfileMvc extends ObserVableViewMvc<ProfileMvc.Listener> {
    public interface Listener{
        void setupToolbar(Toolbar toolbar);
        void setToolbarTitle(String title);
    }
}
