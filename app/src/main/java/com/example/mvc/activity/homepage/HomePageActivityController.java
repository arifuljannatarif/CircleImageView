package com.example.mvc.activity.homepage;

import com.example.mvc.common.ControllerCommonMethods;

public class HomePageActivityController implements ControllerCommonMethods,HomePageMvc.Listener{

    private HomePageMvcImpl viewMvc;
    HomePageActivity mActivity;
    public void onCreate() {

    }
    public void bindView(HomePageMvcImpl viewMvc) {
        this.viewMvc = viewMvc;
        mActivity= (HomePageActivity) viewMvc.getRootView().getContext();
    }
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
    public void onResume() {

    }


}
