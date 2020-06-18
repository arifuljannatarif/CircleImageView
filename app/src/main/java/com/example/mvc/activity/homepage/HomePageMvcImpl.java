package com.example.mvc.activity.homepage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvc.R;
import com.example.mvc.common.navdrawer.BaseNavDrawerViewMvc;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomePageMvcImpl extends BaseNavDrawerViewMvc<HomePageMvc.Listener> implements HomePageMvc, View.OnClickListener {

    TextView nameHint;
    Button button;

    public HomePageMvcImpl(LayoutInflater inflater, ViewGroup parent) {
        super(inflater, parent);
        setmRootView(inflater.inflate(R.layout.activity_home_page, parent, false));

    }

    @Override
    public void initViews() {

    }

    @Override
    public void onClick(View v) {

    }

    public void onViewClicked(View view) {
        switch (view.getId()) {


        }
    }
}
