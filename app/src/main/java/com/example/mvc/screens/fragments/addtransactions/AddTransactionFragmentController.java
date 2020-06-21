package com.example.mvc.screens.fragments.addtransactions;

import android.app.Dialog;
import android.os.Bundle;

import com.example.mvc.interfaces.ControllerCallBack;

public class AddTransactionFragmentController implements ControllerCallBack<AddTransactionMvcimpl>, AddTransactionMvc.Listener {
    private AddTransactionMvcimpl viewMvc;
    Dialog dialog;
    @Override
    public void bindView(AddTransactionMvcimpl viewMvc) {
        this.viewMvc = viewMvc;
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {
        viewMvc.registerListener(this);
    }

    @Override
    public void onStop() {
        viewMvc.unregisterListener(this);
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }

    public AddTransactionMvcimpl geViewMvc() {
        return viewMvc;
    }

    @Override
    public void homeBtnPressed() {
        dialog.dismiss();
    }

    @Override
    public void saveButtonClicked() {
        dialog.dismiss();
    }

    @Override
    public void onEvent(AddTransactionMvcimpl.EVENT event) {
        switch (event){
            case CHANGE_DATE:
                 viewMvc.toggleDatePicker();
                break;
            case CANCEL_DIALOG:
            case SAVE_TRANSACTION:
                dialog.dismiss();
        }
    }
}
