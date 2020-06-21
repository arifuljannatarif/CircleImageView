/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.adapters.calendar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.graphics.drawable.DrawableCompat;

import com.example.mvc.R;
import com.example.mvc.screens.common.views.BaseOvservableViewMvc;
import com.google.android.material.card.MaterialCardView;

import javax.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalendarItemViewMvcImpl extends BaseOvservableViewMvc<CalendarItemViewMvc.Listener> implements CalendarItemViewMvc, View.OnClickListener {
    CalendarRecyclerADapter.DateModel model;
    @BindView(R.id.dayName)
    TextView dayName;
    @BindView(R.id.dayNum)
    TextView dayNum;
    @BindView(R.id.calendarRootLayout)
    MaterialCardView cardView;
    public CalendarItemViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent, int viewType) {
        setRootView(inflater.inflate(R.layout.calendaritem,parent,false));
        ButterKnife.bind(this,getRootView());
        initViews();
    }
    @Override
    public void initViews() {

    }
    @Override
    public void bindDay(CalendarRecyclerADapter.DateModel item) {
        this.model=item;
        dayName.setText(model.getDayName());
        dayNum.setText(model.getDayNum()+"");
        if(model.isInSelected()){
            int color=getContext().getResources().getColor(R.color.green_light);
            cardView.setStrokeWidth(4);
            cardView.setPadding(3,3,3,3);
            dayName.setTextColor(color);
            DrawableCompat.wrap(dayNum.getBackground()).setTint(color);

        }else {
            cardView.setStrokeWidth(0);
            cardView.setPadding(0,0,0,0);
            dayName.setTextColor(getContext().getResources().getColor(R.color.light_gray));
            DrawableCompat.wrap(dayNum.getBackground()).setTint(getContext().getResources().getColor(R.color.light_gray));
        }
    }

    @OnClick({R.id.dayNum,R.id.calendarRootLayout})
    @Override
    public void onClick(View v) {
        for (Listener listener:getListensers()){
            listener.onDateClicked(model);
        }
    }
}
