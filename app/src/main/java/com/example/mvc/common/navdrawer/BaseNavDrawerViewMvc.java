package com.example.mvc.common.navdrawer;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.mvc.R;
import com.example.mvc.common.BaseOvservableViewMvc;
import com.google.android.material.navigation.NavigationView;

public abstract class BaseNavDrawerViewMvc<Listenertype>
        extends BaseOvservableViewMvc<Listenertype> {
    DrawerLayout drawerLayout;
    FrameLayout frameLayout;
    NavigationView navigationView;
    public BaseNavDrawerViewMvc(LayoutInflater inflater, ViewGroup parent){
        super.setmRootView(inflater.inflate(R.layout.layout_drawer,parent,false));
        drawerLayout=findViewById(R.id.drawerLayout);
        frameLayout=findViewById(R.id.frameLayout);
        navigationView=findViewById(R. id.navView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                switch (item.getItemId()){

                }
                return false;
            }
        });

    }


    /**
     * add the passed activity main layout to the containerview
     * @param mRootView
     */
    @Override
    protected void setmRootView(View mRootView) {
        frameLayout.addView(mRootView);
    }
}
