package com.example.mvc.screens.fragments.accounts;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.mvc.interfaces.ControllerCallBack;

public class AccountsController implements ControllerCallBack<AccountFragmentMvcImpl> {
    private AccountFragmentMvcImpl viewMvc;


    @Override
    public void bindView(AccountFragmentMvcImpl viewMvc) {
        this.viewMvc = viewMvc;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {}
    @Override
    public void onStart() {}

    @Override
    public void onStop() {}

    @Override
    public void onPause() {}

    @Override
    public void onDestroy() {}
}
