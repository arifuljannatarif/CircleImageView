/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.fragments.gridchoice;

import com.example.mvc.models.DialogChoiceModel;

import java.util.ArrayList;

public interface GridChoiceMvc {

    public interface Listener {
        public void onItemselected(DialogChoiceModel model);
    }
    public void setAlldata(ArrayList<DialogChoiceModel> list);
}
