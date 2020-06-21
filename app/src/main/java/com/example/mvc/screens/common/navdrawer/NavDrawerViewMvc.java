package com.example.mvc.screens.common.navdrawer;

import android.widget.FrameLayout;

import com.example.mvc.screens.common.views.ObserVableViewMvc;


public interface NavDrawerViewMvc extends ObserVableViewMvc<NavDrawerViewMvc.Listener> {
    interface Listener {
        void onQuestionsListClicked();
    }

    FrameLayout getFragmentFrame();
    boolean isDrawerOpen();
    void openDrawer();
    void closeDrawer();

}
