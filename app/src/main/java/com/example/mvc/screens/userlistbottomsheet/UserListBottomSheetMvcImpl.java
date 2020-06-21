package com.example.mvc.screens.userlistbottomsheet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mvc.R;
import com.example.mvc.screens.common.views.BaseOvservableViewMvc;

public class UserListBottomSheetMvcImpl extends BaseOvservableViewMvc<UserListBottomSheetMvc.Listener> implements UserListBottomSheetMvc {
RelativeLayout progressIndicator;
    private RecyclerView recyclerView;

    public UserListBottomSheetMvcImpl(LayoutInflater inflater, ViewGroup parent) {
        View view=inflater.inflate(R.layout.searchable_bottom_list,parent,false);
        setRootView(view);
        initViews();
    }

    @Override
    public void initViews() {
        progressIndicator=findViewById(R.id.progressLayout);
        Animation animation= AnimationUtils.loadAnimation(getContext(),R.anim.loadin_icon_anim);
        progressIndicator.startAnimation(animation);
         recyclerView=findViewById(R.id.recyclerView);
    }

    @Override
    public void setRecyclerAdapter(RecyclerView.Adapter adapter) {
        if(recyclerView!=null){
            recyclerView.setAdapter(adapter);
        }
    }
}
