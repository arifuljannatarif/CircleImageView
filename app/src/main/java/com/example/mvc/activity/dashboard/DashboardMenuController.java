/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.activity.dashboard;

import android.content.Context;

import com.example.mvc.R;
import com.example.mvc._enums.NavigationEvent;
import com.example.mvc._enums.Navigations;
import com.example.mvc.models.MenuModel;

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
        menus.add(new MenuModel("Home",R.drawable.ic_home_black_24dp, NavigationEvent.HOME));
        menus.add(new MenuModel("Accounts",R.drawable.icon_income, NavigationEvent.ACCOUNTS));
        menus.add(new MenuModel("Summary",R.drawable.icon_expense, NavigationEvent.MONTHLY_SUMMARY));
        menus.add(new MenuModel("add Transaction",R.drawable.icon_expense, NavigationEvent.ADD_TRANSACTION));
        menus.add(new MenuModel("All Users", R.drawable.ic_peaples_account_black_24dp,NavigationEvent.USER_LIST));
        menus.add(new MenuModel("Transaction",R.drawable.icon_expense, NavigationEvent.TRANSACTIONS));
        menus.add(new MenuModel("Add students", R.drawable.ic_peaples_account_black_24dp,NavigationEvent.ADD_NEW_USER));
        menus.add(new MenuModel("Target Users", R.drawable.ic_peaples_account_black_24dp,NavigationEvent.USER_LIST_TARGET));
        menus.add(new MenuModel("Catagories", R.drawable.ic_peaples_account_black_24dp,NavigationEvent.CATAGORIES));
        menus.add(new MenuModel("Profile", android.R.drawable.ic_lock_power_off,NavigationEvent.PROFILE));
        menus.add(new MenuModel("Logout", R.drawable.ic_exit_to_app_black_24dp,NavigationEvent.LOGOUT));

    }

    public ArrayList<MenuModel> getMenus() {
        return menus;
    }

    public void setMenus(ArrayList<MenuModel> menus) {
        this.menus = menus;
    }
}
