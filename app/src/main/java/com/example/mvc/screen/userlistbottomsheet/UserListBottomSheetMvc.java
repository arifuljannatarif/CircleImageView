package com.example.mvc.screen.userlistbottomsheet;

import android.content.DialogInterface;

import androidx.recyclerview.widget.RecyclerView;

public interface UserListBottomSheetMvc {
    interface Listener{
        public void hideBottomSheet();
        public void  onUserSelected();
        void onShow(DialogInterface dialog);
    }
    public void setRecyclerAdapter(RecyclerView.Adapter  adapter);
}

