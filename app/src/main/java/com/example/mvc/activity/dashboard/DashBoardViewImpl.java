/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.activity.dashboard;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.mvc.R;
import com.example.mvc.adapters.DashBoardmenuListAdapter;
import com.example.mvc.screens.common.views.BaseOvservableViewMvc;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashBoardViewImpl extends BaseOvservableViewMvc<DashBoardViewMvc.Listener>
        implements DashBoardViewMvc {
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    @BindView(R.id.drawer_listview)
    ListView drawerListview;
    @BindView(R.id.fragment_container)
    FrameLayout framgentContainer;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    private DashBoardmenuListAdapter drawerMenuAdapter;

    public DashBoardViewImpl(LayoutInflater inflater, ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.activity_main, parent, false));
        initViews();
    }

    @Override
    public void initViews() {
        ButterKnife.bind(this,getRootView());
        drawerListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drawerLayout.closeDrawer(GravityCompat.START);
                for (Listener listener : getListensers()) {
                    listener.onDrawerItemSelected(drawerMenuAdapter.getItem(position).getTarget());
                }

            }
        });
        setupdrawer();
    }

    @Override
    public void toggleDrawer() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public void showProgressbar(boolean state) {
        progressBar.setVisibility(state?View.VISIBLE:View.GONE);
    }

    private void setupdrawer() {
        drawerToggle = new ActionBarDrawerToggle((Activity) getContext(), drawerLayout, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);


            }
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                framgentContainer.setTranslationX(slideOffset * drawerView.getWidth());
            }
        };
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        drawerMenuAdapter = new DashBoardmenuListAdapter(getContext(), android.R.layout.simple_dropdown_item_1line);
        drawerListview.setAdapter(drawerMenuAdapter);
    }


}
