/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.adapters.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalendarRecyclerADapter extends RecyclerView.Adapter<CalendarRecyclerADapter.MyviewHolder>
        implements CalendarItemViewMvc.Listener{
    private ArrayList<DateModel> items;
    int day,month,year;
    Context mContext;
    Listener mListener;
    ArrayList<String> daynames=new ArrayList<>(Arrays.asList(new String[]{"SAT", "SUN", "MON", "TUE", "WED", "THU", "FRI"}));
    public CalendarRecyclerADapter(Context context, CalendarRecyclerADapter.Listener listener,Date date) {
        this.mContext=context;
        items=new ArrayList<>();
        mListener=listener;
        day=date.getDay();
        month=date.getMonth();
        year=date.getYear();
        init(day,month,year);
    }
    public CalendarRecyclerADapter(Context context, CalendarRecyclerADapter.Listener listener) {
        this.mContext=context;
        items=new ArrayList<>();
        mListener=listener;
        Date date=new Date(System.currentTimeMillis());
        day=date.getDay();
        month=date.getMonth();
        year=date.getYear();
        init(day,month,year);
    }
    public void updateDate(){

    }
    public void updateDay( int day){
        boolean selected=false;
        for(int i=0;i<items.size();i++){
            if(day==i+1){
                items.get(i).setInSelected(true);
            }else {
                items.get(i).setInSelected(false);
            }
        }
        notifyItemChanged(this.day);
        this.day=day;
        notifyItemChanged(this.day);

    }

    private void init(int day, int month,int year) {
        this.day=day;
        this.month=month;
        this.year=year;
        String firstDay=getFirstDateOfCurrentMonth(day,month,year).toUpperCase();
        int index=daynames.indexOf(firstDay);
        if(index==-1)return;
        for(int i=1;i<30;i++){
            items.add(new DateModel(i,daynames.get(index%daynames.size()),i==day));
            index++;
        }
    }
    private String getFirstDateOfCurrentMonth(int day, int month,int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, day);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDayOfMonth = cal.getTime();
        DateFormat sdf = new SimpleDateFormat("EE");
        return sdf.format(firstDayOfMonth);
    }
    public void updateSelectedDate(DateModel dateModel){
        boolean selected=false;
        for(int i=0;i<items.size();i++){
            if(!selected && items.get(i).getDayNum()==dateModel.getDayNum()){
                items.get(i).setInSelected(true);
            }else {
                items.get(i).setInSelected(false);
            }
        }
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CalendarItemViewMvc mvc=new CalendarItemViewMvcImpl(LayoutInflater.from(mContext),parent,viewType);
        mvc.registerListener(this);
        return new MyviewHolder(mvc);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {

        holder.viewMvc.bindDay(getItem(position));
    }

    private DateModel getItem(int position) {
        return position<items.size()?items.get(position):null;
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }


    public void clear() {
        this.items.clear();
    }
    public void addAll(List list){
        items.clear();
        items.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public void onDateClicked(DateModel model) {
        updateSelectedDate(model);
    }

    static class MyviewHolder extends RecyclerView.ViewHolder{
        CalendarItemViewMvc viewMvc;
        public MyviewHolder(@NonNull CalendarItemViewMvc itemView) {
            super(itemView.getRootView());
            viewMvc=itemView;
        }
    }
    public class DateModel{
        int dayNum;
        String dayName;
        boolean inSelected;

        public DateModel(int dayNum, String dayName, boolean inSelected) {
            this.dayNum = dayNum;
            this.dayName = dayName;
            this.inSelected = inSelected;
        }

        public int getDayNum() {
            return dayNum;
        }

        public void setDayNum(int dayNum) {
            this.dayNum = dayNum;
        }

        public String getDayName() {
            return dayName;
        }

        public void setDayName(String dayName) {
            this.dayName = dayName;
        }

        public boolean isInSelected() {
            return inSelected;
        }

        public void setInSelected(boolean inSelected) {
            this.inSelected = inSelected;
        }
    }

    public interface Listener {
        void onDateSelected(DateModel model);
    }
}
