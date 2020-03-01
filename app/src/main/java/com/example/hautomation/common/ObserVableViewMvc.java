/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 2/29/20 11:54 AM
 */

package com.example.hautomation.common;

public interface ObserVableViewMvc<ListenerType> extends ViewMvc {
    void registerListener(ListenerType type);
    void unregisterListener(ListenerType type);
}
