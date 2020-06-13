package com.example.mvc.screen.userlistbottomsheet;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;

import com.example.mvc.adapters.transaction.TransactionRecyclerADapter;
import com.example.mvc.fragments.recenttransaction.RecentTransactionMvcImpl;
import com.example.mvc.usecase.UseCaseFactory;

public class UserlistBottomSheetController implements UserListBottomSheetMvc.Listener {
    private UserListBottomSheetMvcImpl viewMvc;
    private UseCaseFactory useCaseFactory;

    public UserlistBottomSheetController(UseCaseFactory useCaseFactory) {
        this.useCaseFactory = useCaseFactory;
    }
    public void bindView(UserListBottomSheetMvcImpl viewMvc) {
        this.viewMvc = viewMvc;
    }
    public void onStart() {
        viewMvc.registerListener(this);

    }
    private Context getContext() {
       return viewMvc==null?null:viewMvc.getRootView().getContext();
    }

    public void onStop() {
        viewMvc.unregisterListener(this);
    }

    @Override
    public void hideBottomSheet() {

    }

    @Override
    public void onUserSelected() {

    }

    @Override
    public void onShow(DialogInterface dialog) {
        viewMvc.setRecyclerAdapter( new TransactionRecyclerADapter(getContext(), new RecentTransactionMvcImpl(LayoutInflater.from(getContext()),null)));
    }
}
