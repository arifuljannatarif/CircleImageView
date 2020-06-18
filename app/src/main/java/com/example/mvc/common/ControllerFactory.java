package com.example.mvc.common;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvc.activity.dashboard.DashBoardController;
import com.example.mvc.activity.navigationManager.NavigationManagerController;
import com.example.mvc.fragments.accounts.AccountsController;
import com.example.mvc.fragments.addtransactions.AddTransactionFragmentController;
import com.example.mvc.screen.userlistbottomsheet.UserlistBottomSheetController;
import com.example.mvc.usecase.UseCaseFactory;

public class ControllerFactory {

    private UseCaseFactory useCaseFactory;

    public ControllerFactory(UseCaseFactory useCaseFactory) {
        this.useCaseFactory = useCaseFactory;
    }

    public DashBoardController getDashBoardActivityController(AppCompatActivity activity){
        return new DashBoardController(activity);
    }

    public UserlistBottomSheetController getUserListSheetController() {
        return new UserlistBottomSheetController(useCaseFactory);
    }

    public AccountsController getAccountFragmentController() {
        return new AccountsController();
    }

    public NavigationManagerController geNavigationManagerActivityController() {
        return new NavigationManagerController();
    }

    public AddTransactionFragmentController getAddTransactionController() {
        return new AddTransactionFragmentController();
    }
}
