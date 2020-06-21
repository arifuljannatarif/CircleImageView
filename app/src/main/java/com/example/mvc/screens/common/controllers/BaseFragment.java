/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.screens.common.controllers;



import androidx.fragment.app.Fragment;

import com.example.mvc.common.CustomApplication;
import com.example.mvc.common.dependencyinjection.ControllerCompossionRoot;
import com.example.mvc.factory.ControllerFactory;
import com.example.mvc.factory.ViewMvcFactory;

public abstract class BaseFragment extends Fragment {
    public abstract void showProgressbar(boolean state);

    private ControllerCompossionRoot controllerCompositionRoot;
    protected ControllerCompossionRoot getCompositionRoot() {
        if (controllerCompositionRoot == null) {
            controllerCompositionRoot = new ControllerCompossionRoot(((CustomApplication) requireActivity().getApplication()).getCompositionRoot(), requireActivity());
        }
        return controllerCompositionRoot;
    }
    protected ViewMvcFactory getViewMvcFactory() {
        return getCompositionRoot().getViewMvcFactory();
    }

    protected ControllerFactory getControllerFactory() {
        return getCompositionRoot().getControllerFactory();
    }

}
