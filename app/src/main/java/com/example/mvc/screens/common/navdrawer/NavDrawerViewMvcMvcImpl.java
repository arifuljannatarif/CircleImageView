package com.example.mvc.screens.common.navdrawer;


import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.mvc.R;
import com.example.mvc.screens.common.views.BaseOvservableViewMvc;
import com.google.android.material.navigation.NavigationView;

public class NavDrawerViewMvcMvcImpl extends BaseOvservableViewMvc<NavDrawerViewMvc.Listener>
        implements NavDrawerViewMvc {
    private final DrawerLayout mDrawerLayout;
    private final FrameLayout mFrameLayout;
    private final NavigationView mNavigationView;

    public NavDrawerViewMvcMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_drawer_new, parent, false));
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mFrameLayout = findViewById(R.id.frame_content);
        mNavigationView = findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();
                /*if (item.getItemId() == R.id.drawer_menu_questions_list) {
                    for (Listener listener : getListeners()) {
                        listener.onQuestionsListClicked();
                    }
                }*/
                return false;
            }
        });
    }

    @Override
    public void openDrawer() {
        mDrawerLayout.openDrawer(GravityCompat.START);
    }

    @Override
    public boolean isDrawerOpen() {
        return mDrawerLayout.isDrawerOpen(GravityCompat.START);
    }

    @Override
    public void closeDrawer() {
        mDrawerLayout.closeDrawers();
    }

    @Override
    public FrameLayout getFragmentFrame() {
        return mFrameLayout;
    }

    @Override
    public void initViews() {

    }
}
