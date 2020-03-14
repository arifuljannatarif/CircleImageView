/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/3/20 12:22 AM
 */

package com.example.hautomation.models;

import com.example.hautomation._enums.Navigations;

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