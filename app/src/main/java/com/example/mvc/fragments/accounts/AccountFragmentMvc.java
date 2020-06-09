/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.fragments.accounts;

import com.example.mvc.common.ObserVableViewMvc;
import com.example.mvc.interfaces.FragmentHandler;

public interface AccountFragmentMvc extends ObserVableViewMvc<AccountFragmentMvc.Listener> {

    public interface Listener extends FragmentHandler {

    }

}
