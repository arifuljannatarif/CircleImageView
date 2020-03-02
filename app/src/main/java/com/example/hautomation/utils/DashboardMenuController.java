/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/2/20 10:43 PM
 */

package com.example.hautomation.utils;

import android.content.Context;

import com.example.hautomation.R;
import com.example.hautomation._enums.Navigations;
import com.example.hautomation.profile.Profile;

import java.util.ArrayList;

public class DashboardMenuController {
    ArrayList<MenuModel> menus;
    Context mContext;
    private static DashboardMenuController menuController;
    public DashboardMenuController(Context context) {
        menus=new ArrayList<>();
        this.mContext=context;
        addmenus();
    }


    public static DashboardMenuController getInstance(Context context){
        if(menuController==null)menuController=new DashboardMenuController(context);
        return menuController;
    }

    private void addmenus() {
        menus.add(new MenuModel("Add new Student",R.drawable.icon_balance, Navigations.PROFILE));
        menus.add(new MenuModel("View Student List", R.drawable.ic_exit_to_app_black_24dp,Navigations.TRANSACTIONS));
    }

    public ArrayList<MenuModel> getMenus() {
        return menus;
    }

    public void setMenus(ArrayList<MenuModel> menus) {
        this.menus = menus;
    }
}
