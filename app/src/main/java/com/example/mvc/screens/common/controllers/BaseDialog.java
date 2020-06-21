package com.example.mvc.screens.common.controllers;


import androidx.fragment.app.DialogFragment;

import com.example.mvc.common.CustomApplication;
import com.example.mvc.common.dependencyinjection.ControllerCompossionRoot;

public abstract class BaseDialog extends DialogFragment {


    private ControllerCompossionRoot mControllerCompositionRoot;

    protected ControllerCompossionRoot getCompositionRoot() {
        if (mControllerCompositionRoot == null) {
            mControllerCompositionRoot = new ControllerCompossionRoot(
                    ((CustomApplication) requireActivity().getApplication()).getCompositionRoot(),
                    requireActivity()
            );
        }
        return mControllerCompositionRoot;
    }

}
