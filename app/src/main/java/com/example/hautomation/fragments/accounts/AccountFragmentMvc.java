/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/14/20 11:07 AM
 */

package com.example.hautomation.fragments.accounts;

import com.example.hautomation.common.ObserVableViewMvc;
import com.example.hautomation.interfaces.FragmentHandler;

public interface AccountFragmentMvc extends ObserVableViewMvc<AccountFragmentMvc.Listener> {

    public interface Listener extends FragmentHandler {

    }

}
