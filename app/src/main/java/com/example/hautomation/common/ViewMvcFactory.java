/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/19/20 11:27 AM
 */

package com.example.hautomation.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.hautomation.activity.dashboard.DashBoardViewMvc;
import com.example.hautomation.activity.dashboard.DashBoardViewMvcImpl;
import com.example.hautomation.activity.profile.ProfileMvc;
import com.example.hautomation.activity.profile.ProfileMvcImpl;
import com.example.hautomation.fragments.accounts.AccountFragmentMvc;
import com.example.hautomation.fragments.accounts.AccountFragmentMvcImpl;
import com.example.hautomation.fragments.recenttransaction.RecentTransactionMvc;
import com.example.hautomation.fragments.recenttransaction.RecentTransactionMvcImpl;
import com.example.hautomation.fragments.userlist.UserlistMvc;
import com.example.hautomation.fragments.userlist.UserlistMvcImpl;

import org.jetbrains.annotations.Nullable;

public class ViewMvcFactory {
    private LayoutInflater mLayoutInflater;
    public ViewMvcFactory(LayoutInflater mLayoutInflater) {
        this.mLayoutInflater = mLayoutInflater;
    }
    public DashBoardViewMvc getDashboardViewMvc(@Nullable ViewGroup parent){
        return new DashBoardViewMvcImpl(mLayoutInflater,parent);
    }
    public AccountFragmentMvc getAccountFragmentMvc(@Nullable  ViewGroup parent){
        return new AccountFragmentMvcImpl(mLayoutInflater,parent);
    }
    public ProfileMvc getProfileMvc(@Nullable ViewGroup parent){
        return new ProfileMvcImpl(mLayoutInflater,parent);
    }
    public RecentTransactionMvc getRecentTransactionMvc(@Nullable ViewGroup parent){
        return new RecentTransactionMvcImpl(mLayoutInflater,parent);
    }
    public UserlistMvc  getUserlistMvc(@Nullable ViewGroup parent){
        return new UserlistMvcImpl(mLayoutInflater,parent);
    }

}
