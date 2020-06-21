package com.example.mvc.screens.common.navdrawer;

import com.example.mvc._enums.NavigationEvent;

public interface NavDrawerHelper {
    public void onDraweItemCLicked(NavigationEvent event);
    void openDrawer();
    void closeDrawer();
    boolean isDrawerOpen();
}
