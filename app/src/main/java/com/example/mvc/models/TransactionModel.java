/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.models;

import com.example.mvc._enums.TransactionMode;
import com.example.mvc._enums.TransactionType;

public class TransactionModel {
    TransactionType transactionType;
    TransactionMode transactionMode;
    public TransactionModel() { }

    public TransactionType getTransactionType(boolean isenum) {
        return transactionType;
    }
    public String getTransactionType() {
        return transactionType==null?null:transactionType.toString();
    }
    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
    public void setTransactionType(String transactionType) {
        if(transactionType!=null)
        this.transactionType = TransactionType.valueOf(transactionType);
    }

    public TransactionMode getTransactionMode() {
        return transactionMode;
    }

    public void setTransactionMode(TransactionMode transactionMode) {
        this.transactionMode = transactionMode;
    }
}
