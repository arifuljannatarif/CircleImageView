package com.example.mvc.fragments.addtransactions;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import com.example.mvc.ControllerCallBack;

import java.util.Date;

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
                new DatePickerDialog(dialog.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        viewMvc.changeDate(String.format("%s/%s/%s",dayOfMonth,month,year));
                    }
                }, 2013, 2, 18).show();
                break;
            case CANCEL_DIALOG:
            case SAVE_TRANSACTION:
                dialog.dismiss();
        }
    }
}
