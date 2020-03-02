/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/1/20 12:41 PM
 */

package com.example.hautomation.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.hautomation.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class BottomDialogFragment extends BottomSheetDialogFragment {
    public interface MonthSelected{
        public void onMonthSelected(String month);
    }
    public  int x;
    private MonthSelected monthSelected;

    public void setMonthSelected(MonthSelected monthSelected) {
        this.monthSelected = monthSelected;
    }

    public ListView getListView() {
        return listView;
    }

    public void setListView(ListView listView) {
        this.listView = listView;
    }

    Context mContext;
    ListView listView;

    public BottomDialogFragment(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomDialogFragment.STYLE_NO_FRAME,R.style.AppBottomSheetDialogTheme);
    }
    public static BottomSheetDialogFragment getinstance(Context c){
        return new BottomDialogFragment(c);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.month_selector_bottomsheet,container,false);
        listView=view.findViewById(R.id.month_listview);
        final ArrayAdapter<String> adapter=new ArrayAdapter<>(mContext,android.R.layout.simple_list_item_single_choice,new ArrayList<String>());
        adapter.add("January 2020");
        adapter.add("February 2020");
        adapter.add("March 2020");
        adapter.add("April 2020");
        adapter.add("May 2020");
        adapter.add("June 2020");
        adapter.add("January 2020");
        adapter.add("July 2020");
        adapter.add("August 2020");
        adapter.add("Semptember 2020");
        adapter.add("October 2020");
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(monthSelected!=null)
                    monthSelected.onMonthSelected(adapter.getItem(position));
                dismiss();
            }
        });
        if(getDialog()!=null && getDialog().getWindow()!=null)
            getDialog().getWindow().setBackgroundDrawableResource(android.R.drawable.screen_background_dark_transparent);
        return view;
    }
}
