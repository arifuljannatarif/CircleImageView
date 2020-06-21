/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.screens.common.views;

import android.widget.Toast;

import com.example.mvc.screens.common.views.BaseViewMvc;
import com.example.mvc.screens.common.views.ObserVableViewMvc;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseOvservableViewMvc<ListenserType> extends BaseViewMvc
        implements ObserVableViewMvc<ListenserType> {
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
    protected void showToast(String msg){
        Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT).show();
    }

}
