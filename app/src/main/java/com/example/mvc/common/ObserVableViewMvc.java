/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.common;

public interface ObserVableViewMvc<ListenerType> extends ViewMvc {
    void registerListener(ListenerType type);
    void unregisterListener(ListenerType type);
}
