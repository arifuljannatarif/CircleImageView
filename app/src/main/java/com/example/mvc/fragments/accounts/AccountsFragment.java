/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.fragments.accounts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mvc.common.ViewMvcFactory;
import com.example.mvc.fragments.RefreshFragment;

public class AccountsFragment extends RefreshFragment implements AccountFragmentMvc.Listener {
   AccountFragmentMvcImpl mvcView;
   ViewMvcFactory mvcFactory;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      //  mvcView=mvcFactory.getAccountFragmentMvc(container);
        mvcView = new AccountFragmentMvcImpl(inflater,container);
        mvcView.registerListener(this);
        return mvcView.getRootView();
    }

    @Override
    public void showProgressbar(boolean state) {

    }

    @Override
    public Fragment getCurrentFragment() {
        return null;
    }
}
