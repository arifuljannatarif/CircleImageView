/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mvc.activity.dashboard.DashBoardViewMvc;
import com.example.mvc.activity.dashboard.DashBoardViewMvcImpl;
import com.example.mvc.activity.homepage.HomePageMvcImpl;
import com.example.mvc.activity.profile.ProfileMvc;
import com.example.mvc.activity.profile.ProfileMvcImpl;
import com.example.mvc.fragments.accounts.AccountFragmentMvc;
import com.example.mvc.fragments.accounts.AccountFragmentMvcImpl;
import com.example.mvc.fragments.recenttransaction.RecentTransactionMvc;
import com.example.mvc.fragments.recenttransaction.RecentTransactionMvcImpl;
import com.example.mvc.fragments.userlist.UserlistMvc;
import com.example.mvc.fragments.userlist.UserlistMvcImpl;

import org.jetbrains.annotations.Nullable;

public class ViewMvcFactory {
    private LayoutInflater mLayoutInflater;
    public ViewMvcFactory(LayoutInflater mLayoutInflater) {
        this.mLayoutInflater = mLayoutInflater;
    }
    public DashBoardViewMvc getDashboardViewMvc(@Nullable ViewGroup parent){
        return new DashBoardViewMvcImpl(mLayoutInflater,parent);
    }
    public AccountFragmentMvcImpl getAccountFragmentMvc(@Nullable  ViewGroup parent){
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

    public HomePageMvcImpl getHomePageMvc(ViewGroup parent) {
        return new HomePageMvcImpl(mLayoutInflater,parent);
    }
}
