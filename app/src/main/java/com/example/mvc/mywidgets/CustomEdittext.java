/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.mywidgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

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
