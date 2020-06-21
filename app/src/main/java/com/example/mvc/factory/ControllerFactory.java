package com.example.mvc.factory;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvc.activity.dashboard.DashBoardController;
import com.example.mvc.activity.navigationManager.MainActivityController;
import com.example.mvc.common.dependencyinjection.ControllerCompossionRoot;
import com.example.mvc.screens.fragments.accounts.AccountsController;
import com.example.mvc.screens.fragments.addtransactions.AddTransactionFragmentController;
import com.example.mvc.screens.fragments.gridchoice.dashboard.DashboardFragmentController;
import com.example.mvc.screens.userlistbottomsheet.UserlistBottomSheetController;

public class ControllerFactory {

    private UseCaseFactory useCaseFactory;
    private ControllerCompossionRoot controllerCompossionRoot;
    public ControllerFactory(UseCaseFactory useCaseFactory, ControllerCompossionRoot controllerCompossionRoot) {
        this.useCaseFactory = useCaseFactory;
        this.controllerCompossionRoot = controllerCompossionRoot;
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

    public MainActivityController geNavigationManagerActivityController(Activity activity) {
        return new MainActivityController(activity,controllerCompossionRoot.getScreensNavigator());
    }

    public AddTransactionFragmentController getAddTransactionController() {
        return new AddTransactionFragmentController();
    }

    public DashboardFragmentController getDashBoardFragmetnController() {
        return new DashboardFragmentController();
    }
}
