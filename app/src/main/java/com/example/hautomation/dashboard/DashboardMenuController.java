/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/3/20 12:22 AM
 */

package com.example.hautomation.dashboard;

import android.content.Context;

import com.example.hautomation.R;
import com.example.hautomation._enums.Navigations;
import com.example.hautomation.models.MenuModel;

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
        menus.add(new MenuModel("Payment",R.drawable.icon_income, Navigations.PROFILE));
        menus.add(new MenuModel("Expenses",R.drawable.icon_expense, Navigations.PROFILE));
        menus.add(new MenuModel("Transactions details",R.drawable.icon_expense, Navigations.TRANSACTIONS));
        menus.add(new MenuModel("Add students", R.drawable.ic_peaples_account_black_24dp,Navigations.PROFILE));
        menus.add(new MenuModel("All Users", R.drawable.ic_peaples_account_black_24dp,Navigations.TRANSACTIONS));
    }

    public ArrayList<MenuModel> getMenus() {
        return menus;
    }

    public void setMenus(ArrayList<MenuModel> menus) {
        this.menus = menus;
    }
}
