package com.example.mvc.activity.navigationManager;

import android.os.Bundle;

import com.example.mvc.ControllerCallBack;

public class NavigationManagerController implements ControllerCallBack<NavigationManagerViewImpl>, NavigationManagerMvc.Listener {
    private NavigationManagerViewImpl viewMvc;
    enum FragmentsName{
        ACCOUNT_FRAGMENT,
        DASHBOARD_FRAGMENT
    }
    FragmentsName currentFragment;
    @Override
    public void bindView(NavigationManagerViewImpl viewMvc) {
        this.viewMvc = viewMvc;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { }

    @Override
    public void onStart() {
        viewMvc.registerListener(this);
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
    private void changeFragment(FragmentsName name){
        switch (name){
            case ACCOUNT_FRAGMENT:
                break;
            case DASHBOARD_FRAGMENT:
                break;
        }
    }
}
