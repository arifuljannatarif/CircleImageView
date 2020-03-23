/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/14/20 11:07 AM
 */

package com.example.hautomation.fragments.accounts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hautomation.fragments.RefreshFragment;

public class AccountsFragment extends RefreshFragment implements AccountFragmentMvc.Listener {
   AccountFragmentMvcImpl mvcView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mvcView=new AccountFragmentMvcImpl(inflater,container);
        mvcView.registerListener(this);
        return mvcView.getRootView();
    }

    @Override
    public Fragment getCurrentFragment() {
        return null;
    }

    @Override
    public void showProgressbar(boolean state) {

    }
}
