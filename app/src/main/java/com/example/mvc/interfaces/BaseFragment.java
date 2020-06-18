/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.interfaces;

import androidx.fragment.app.Fragment;

import com.example.mvc.CustomApplication;
import com.example.mvc.common.ControllerFactory;
import com.example.mvc.common.ViewMvcFactory;
import com.example.mvc.common.dependencyinjection.ControllerCompossionRoot;

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
