/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mvc.R;
import com.example.mvc.activity.dashboard.DashboardMenuController;
import com.example.mvc.models.MenuModel;

import java.util.ArrayList;

public class DashBoardmenuListAdapter extends ArrayAdapter<MenuModel> {
    ArrayList<MenuModel> menuModels;
    Context mContext;
    public DashBoardmenuListAdapter(@NonNull Context context,int resid) {
        super(context,resid);
        this.mContext=context;
        menuModels=new ArrayList<>();
        menuModels.addAll(DashboardMenuController.getInstance(context).getMenus());
    }

    @Override
    public int getCount() {
        return menuModels.size();
    }

    @Override
    public MenuModel getItem(int position) {
        return menuModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView=LayoutInflater.from(mContext).inflate(R.layout.drawer_menu_items,parent,false);
        ((TextView)convertView).setCompoundDrawablesRelativeWithIntrinsicBounds(getItem(position).getDrawableLeft(),0,0,0);
        ((TextView)convertView).setText(getItem(position).getTitle());
        return convertView;
    }
}
