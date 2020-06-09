package com.example.mvc.common;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvc.activity.dashboard.DashBoardController;

public class ControllerFactory {

    public DashBoardController getDashBoardActivityController(AppCompatActivity activity){
        return new DashBoardController(activity);
    }

}
