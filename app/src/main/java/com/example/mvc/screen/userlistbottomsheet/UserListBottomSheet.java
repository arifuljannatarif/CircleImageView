package com.example.mvc.screen.userlistbottomsheet;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mvc.fragments.BaseBottomSheet;

public class UserListBottomSheet extends BaseBottomSheet {
    UserlistBottomSheetController userListController;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userListController=getComposionRoot().getControllerFactory().getUserListSheetController();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        UserListBottomSheetMvcImpl viewMvc=getComposionRoot().getViewMvcFactory().getUserListSheetMvc(inflater,container);
        userListController.bindView(viewMvc);
        return viewMvc.getRootView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDialog().setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                userListController.onShow(dialog);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        userListController.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        userListController.onStop();
    }
}
