/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/21/20 8:25 PM
 */

package com.example.hautomation.fragments.gridchoice;

import com.example.hautomation.models.DialogChoiceModel;

import java.util.ArrayList;

public interface GridChoiceMvc {

    public interface Listener {
        public void onItemselected(DialogChoiceModel model);
    }
    public void setAlldata(ArrayList<DialogChoiceModel> list);
}
