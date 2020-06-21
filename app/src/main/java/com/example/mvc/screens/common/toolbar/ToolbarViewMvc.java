package com.example.mvc.screens.common.toolbar;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvc.R;
import com.example.mvc.screens.common.views.BaseViewMvc;

public class ToolbarViewMvc extends BaseViewMvc {
    TextView title;
    public ToolbarViewMvc(LayoutInflater inflater, ViewGroup parent){
        setRootView(inflater.inflate(R.layout.layout_toolbar,parent,false));
    }
    @Override
    public void initViews() {

    }
}
