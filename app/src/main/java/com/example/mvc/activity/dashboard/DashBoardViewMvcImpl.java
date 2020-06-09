/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.activity.dashboard;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mvc.R;
import com.example.mvc._enums.Navigations;
import com.example.mvc.adapters.DashBoardmenuListAdapter;
import com.example.mvc.common.BaseOvservableViewMvc;
import com.google.android.material.appbar.AppBarLayout;

public class DashBoardViewMvcImpl extends BaseOvservableViewMvc<DashBoardViewMvc.Listener>
        implements DashBoardViewMvc {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;
    AppBarLayout appBarLayout;
    SwipeRefreshLayout swipeRefreshLayout;
    ListView drawerListview;
    private DashBoardmenuListAdapter drawerMenuAdapter;
    Navigations selNavigation;

    public DashBoardViewMvcImpl(LayoutInflater inflater, ViewGroup parent) {
        setmRootView(inflater.inflate(R.layout.activity_main, parent, false));
        initViews();
    }

    @Override
    public void initViews() {
        swipeRefreshLayout = findViewById(R.id.swiperefresh);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        drawerListview = findViewById(R.id.drawer_listview);
        drawerListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drawerLayout.closeDrawer(GravityCompat.START);
                for (Listener listener : getListensers()) {
                    listener.changeActivity(drawerMenuAdapter.getItem(position).getTarget());
                }

            }
        });
        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.YELLOW, Color.LTGRAY);
        // swipeRefreshLayout.setProgressViewEndTarget(true,0);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                for (Listener listener : getListensers())
                    listener.onswipeRefresh(swipeRefreshLayout.isRefreshing());
            }
        });
        appBarLayout = findViewById(R.id.appbar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    if (swipeRefreshLayout.isRefreshing())
                        swipeRefreshLayout.setRefreshing(true);
                    swipeRefreshLayout.setEnabled(true);
                } else swipeRefreshLayout.setEnabled(false);
            }
        });
        setUpToolbar();
        setupdrawer();
    }

    @Override
    public void setSwiperefreshing(boolean state) {
        if (swipeRefreshLayout != null)
            swipeRefreshLayout.setRefreshing(state);
    }

    @Override
    public void refresh() {

    }

    @Override
    public void showProgressbar(boolean state) {
    }


    private void setUpToolbar() {
        for (Listener listener : getListensers()) {
            listener.setToolbar(toolbar);
            listener.setToolbarTitle("Home");
        }
    }

    private void setupdrawer() {
        drawerToggle = new ActionBarDrawerToggle((Activity) getContext(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                View container = findViewById(R.id.swiperefresh);
                container.setTranslationX(slideOffset * drawerView.getWidth());
            }
        };
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        drawerMenuAdapter = new DashBoardmenuListAdapter(getContext(), android.R.layout.simple_dropdown_item_1line);
        drawerListview.setAdapter(drawerMenuAdapter);
    }


}
