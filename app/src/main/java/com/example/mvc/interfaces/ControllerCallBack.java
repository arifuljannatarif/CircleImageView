package com.example.mvc.interfaces;

import android.os.Bundle;

public interface ControllerCallBack<type> {
    void bindView(type viewMvc);
    void onCreate(Bundle savedInstanceState);
    void onStart();
    void onStop();
    void onPause();
    void onDestroy();

}
