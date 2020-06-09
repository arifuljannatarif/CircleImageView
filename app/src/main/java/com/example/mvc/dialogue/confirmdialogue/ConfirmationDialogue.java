/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/25/20 1:08 AM
 */

package com.example.mvc.dialogue.confirmdialogue;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.example.mvc.R;

public class ConfirmationDialogue extends Dialog {

    public ConfirmationDialogue(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation_dialog_layout);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }


}
