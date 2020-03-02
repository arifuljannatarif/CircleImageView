/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/2/20 10:43 PM
 */

package com.example.hautomation.utils;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hautomation._enums.Navigations;
import com.example.hautomation.profile.Profile;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MenuModel {
    String title;
    int drawableLeft=0;
    int drawableRight=0;
    Navigations target;

    public MenuModel(String title, int drawableLeft, int drawableRight, Navigations target) {
        this.title = title;
        this.drawableLeft = drawableLeft;
        this.drawableRight = drawableRight;
        this.target = target;
    }

    public MenuModel(String title, int drawableLeft, Navigations target) {
        this.title = title;
        this.drawableLeft = drawableLeft;
        this.target = target;
    }


    public MenuModel(String title, Navigations navigations) {
        this.title = title;
        this.target=navigations;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDrawableLeft() {
        return drawableLeft;
    }

    public void setDrawableLeft(int drawableLeft) {
        this.drawableLeft = drawableLeft;
    }

    public int getDrawableRight() {
        return drawableRight;
    }

    public void setDrawableRight(int drawableRight) {
        this.drawableRight = drawableRight;
    }

    public Navigations getTarget() {
        return target;
    }

    public void setTarget(Navigations target) {
        this.target = target;
    }
}
