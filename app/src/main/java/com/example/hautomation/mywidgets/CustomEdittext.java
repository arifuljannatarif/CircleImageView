/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 2/26/20 9:05 AM
 */

package com.example.hautomation.mywidgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.EditText;

import com.example.hautomation.R;

public class CustomEdittext extends EditText {

    public CustomEdittext(Context context) {
        super(context);
    }

    public CustomEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);
        retriveattribute(context,attrs);
    }

    public CustomEdittext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        retriveattribute(context,attrs);
    }

    public CustomEdittext(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        retriveattribute(context,attrs);
    }
    void retriveattribute(Context context,AttributeSet attrs){


    }
}
