package com.example.mvc.fragments;

import com.example.mvc.CustomApplication;
import com.example.mvc.common.dependencyinjection.ControllerCompossionRoot;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public abstract class BaseBottomSheet extends BottomSheetDialogFragment {
    ControllerCompossionRoot composionRoot;
    protected ControllerCompossionRoot getComposionRoot(){
        if (composionRoot == null) {
            composionRoot = new ControllerCompossionRoot(((CustomApplication) requireActivity().getApplication()).getmCompositionRoot(), requireActivity());
        }
        return composionRoot;
    }
}
