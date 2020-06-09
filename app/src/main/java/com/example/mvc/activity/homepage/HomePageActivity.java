package com.example.mvc.activity.homepage;

import android.os.Bundle;

import com.example.mvc.activity.BaseActivity;
import com.example.mvc.utils.SharedPreferencesManager;
import com.example.mvc.utils.Utils;

public class HomePageActivity extends BaseActivity {
    HomePageActivityController mController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Utils().changeTheme(this,new SharedPreferencesManager(this).retrieveInt("theme",1));
        HomePageMvcImpl viewMvc = getCompositionRoot().getViewMvcFactory().getHomePageMvc(null);
        mController=getCompositionRoot().geHomePageActivityController();
        mController.bindView(viewMvc);
        setContentView(viewMvc.getRootView());
        mController.onCreate();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mController.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mController.onStop();
    }
}
