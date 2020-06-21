package com.example.mvc.screens.common.screennavigator;


import android.app.Activity;
import android.content.Intent;

import com.example.mvc.activity.login.Login;
import com.example.mvc.screens.fragments.gridchoice.dashboard.DashboardFragment;
import com.example.mvc.screens.common.fragmentframehelper.FragmentFrameHelper;

public class ScreensNavigator {

    private FragmentFrameHelper mFragmentFrameHelper;

    public ScreensNavigator(FragmentFrameHelper fragmentFrameHelper) {
        mFragmentFrameHelper = fragmentFrameHelper;
    }

    public void toDashBoardFragment(){
        mFragmentFrameHelper.replaceFragment(new DashboardFragment());
    }

   /* public void toQuestionDetails(String questionId) {
        mFragmentFrameHelper.replaceFragment(QuestionDetailsFragment.newInstance(questionId));
    }

    public void toQuestionsList() {
        mFragmentFrameHelper.replaceFragmentAndClearBackstack(QuestionsListFragment.newInstance());
    }*/

    public void navigateUp() {
        mFragmentFrameHelper.navigateUp();
    }

    public void toLoginScreen(Activity activity) {
        activity.startActivity(new Intent(activity, Login.class));
    }
}
