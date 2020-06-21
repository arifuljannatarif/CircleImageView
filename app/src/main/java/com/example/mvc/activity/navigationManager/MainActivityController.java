package com.example.mvc.activity.navigationManager;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mvc._enums.NavigationEvent;
import com.example.mvc.interfaces.ControllerCallBack;
import com.example.mvc.screens.common.controllers.BackPressDispatcher;
import com.example.mvc.screens.common.controllers.BackPressedListener;
import com.example.mvc.screens.common.fragmentframehelper.FragmentFrameWrapper;
import com.example.mvc.screens.common.navdrawer.NavDrawerHelper;
import com.example.mvc.screens.common.screennavigator.ScreensNavigator;

import java.util.HashSet;
import java.util.Set;

public class MainActivityController implements
        ControllerCallBack<MainactivityMvcImpl>,
        NavigationManagerMvc.Listener, BackPressDispatcher,
        FragmentFrameWrapper{


    private final Set<BackPressedListener> mBackPressedListeners = new HashSet<>();
    private Activity activity;
    private ScreensNavigator mScreensNavigator;

    private MainactivityMvcImpl viewMvc;
    public MainActivityController(Activity activity,ScreensNavigator screensNavigator){
        this.activity = activity;
        this.mScreensNavigator = screensNavigator;
    }
    @Override
    public void registerListener(BackPressedListener listener) {
        if(listener!=null)  mBackPressedListeners.add(listener);
    }

    @Override
    public void unregisterListener(BackPressedListener listener) {
        if(listener!=null)  mBackPressedListeners.remove(listener);
    }

    @Override
    public FrameLayout getFragmentFrame() {
        return null;
    }
    @Override
    public void bindView(@NonNull MainactivityMvcImpl viewMvc) {
        this.viewMvc = viewMvc;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) { }

    @Override
    public void onStart() {
        viewMvc.registerListener(this);
        mScreensNavigator.toDashBoardFragment();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mScreensNavigator.navigateUp();
            }
        },7000);
    }

    @Override
    public void onStop() {
        viewMvc.unregisterListener(this);
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onDraweItemCLicked(NavigationEvent event) {
        switch (event){
            case HOME:
                mScreensNavigator.toDashBoardFragment();
                break;
            case LOGOUT:
                mScreensNavigator.toLoginScreen(activity);
                break;
        }
    }
}
