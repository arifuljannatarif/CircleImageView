/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/2/20 9:06 PM
 */

package com.example.hautomation.activity.profile;

import androidx.appcompat.widget.Toolbar;

import com.example.hautomation.common.ObserVableViewMvc;

public interface ProfileMvc extends ObserVableViewMvc<ProfileMvc.Listener> {
    public interface Listener{
        void setupToolbar(Toolbar toolbar);
        void setToolbarTitle(String title);
    }
}
