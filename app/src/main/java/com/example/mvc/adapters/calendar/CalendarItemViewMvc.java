/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.adapters.calendar;

import com.example.mvc.screens.common.views.ObserVableViewMvc;

public interface CalendarItemViewMvc extends ObserVableViewMvc<CalendarItemViewMvc.Listener> {

    void bindDay(CalendarRecyclerADapter.DateModel item);

    interface Listener{
        void onDateClicked(CalendarRecyclerADapter.DateModel model);
    }
}
