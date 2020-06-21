package com.example.mvc.activity.navigationManager;

import com.example.mvc._enums.NavigationEvent;

public interface NavigationManagerMvc {
    public interface Listener {
        void onDraweItemCLicked(NavigationEvent event);
    }
}
