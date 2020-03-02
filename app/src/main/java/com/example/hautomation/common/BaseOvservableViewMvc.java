/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 2/29/20 12:08 PM
 */

package com.example.hautomation.common;

import android.util.Log;
import android.widget.Toast;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseOvservableViewMvc<ListenserType> extends BaseViewMvc
        implements ObserVableViewMvc<ListenserType>{
    private Set<ListenserType> mListensers=new HashSet<>();
    @Override
    public void registerListener(ListenserType listenserType) {
        mListensers.add(listenserType);
    }
    @Override
    public void unregisterListener(ListenserType listenserType) {
        mListensers.remove(listenserType);
    }
    protected Set<ListenserType> getListensers(){
        return Collections.unmodifiableSet(mListensers);
    }

}
