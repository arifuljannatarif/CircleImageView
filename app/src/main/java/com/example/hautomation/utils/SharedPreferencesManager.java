/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/8/20 12:26 AM
 */

package com.example.hautomation.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class SharedPreferencesManager {

    private SharedPreferences sPreferences;

    private final String PREFERENCE_NAME = "preference";
    private SharedPreferences.Editor sEditor;


    public SharedPreferencesManager(Context context) {
        sPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    private SharedPreferences.Editor getEditor() {
        return sPreferences.edit();
    }


    public void storeBoolean(String tag, boolean value) {
        sEditor = getEditor();
        sEditor.putBoolean(tag, value);
        sEditor.commit();
    }


    public void storeString(String tag, String str) {
        sEditor = getEditor();
        sEditor.putString(tag, str);
        sEditor.commit();
    }


    public boolean retrieveBoolean(String tag, boolean defValue) {
        return sPreferences.getBoolean(tag, defValue);

    }


    public String retrieveString(String tag, String defStr) {
        return sPreferences.getString(tag, defStr);
    }

    public int retrieveInt(String tag, int defValue) {
        int cur=sPreferences.getInt(tag, defValue);
        storeInt(tag,cur==0?1:0);
        return cur;
    }


    public void storeInt(String tag, int defValue) {
        sEditor = getEditor();
        sEditor.putInt(tag, defValue);
        sEditor.commit();
    }
}