package com.example.mvc.screens.common.navdrawer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;

import com.example.mvc.R;
import com.example.mvc._enums.NavigationEvent;
import com.example.mvc.adapters.DashBoardmenuListAdapter;
import com.example.mvc.databinding.LayoutDrawerBinding;
import com.example.mvc.screens.common.views.BaseOvservableViewMvc;

public abstract class BaseNavDrawerViewMvc<Listenertype>
        extends BaseOvservableViewMvc<Listenertype> implements NavDrawerHelper {
    private LayoutDrawerBinding binding;
    private ActionBarDrawerToggle drawerToggle;
    private DashBoardmenuListAdapter drawerMenuAdapter;

    public BaseNavDrawerViewMvc(LayoutInflater inflater, ViewGroup parent){
        super.setRootView(inflater.inflate(R.layout.layout_drawer,parent,false));
        binding =LayoutDrawerBinding.bind(getRootView());
        binding.nav.drawerListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                onDraweItemCLicked(drawerMenuAdapter.getItem(position).getTarget());

            }
        });
        setupdrawer();
    }
    private void setupdrawer() {
        drawerToggle = new ActionBarDrawerToggle((Activity) getContext(), binding.drawerLayout, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                binding.fragmentContainer.setTranslationX(slideOffset * drawerView.getWidth());
            }
        };
        drawerToggle.setDrawerIndicatorEnabled(true);
        binding.drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        drawerMenuAdapter = new DashBoardmenuListAdapter(getContext(), android.R.layout.simple_dropdown_item_1line);
        binding.nav.drawerListview.setAdapter(drawerMenuAdapter);
    }
    /**
     * add the passed activity main layout to the containerview
     * @param mRootView
     */
    @Override
    protected void setRootView(View mRootView) {
        binding.mainContent.addView(mRootView);
    }

    @Override
    public void openDrawer() {

    }

    @Override
    public void closeDrawer() {

    }

    @Override
    public boolean isDrawerOpen() {
        return binding.drawerLayout.isDrawerOpen(GravityCompat.START);
    }

    @Override
    public void onDraweItemCLicked(NavigationEvent event) {

    }
}
