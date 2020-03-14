/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/3/20 2:48 PM
 */

package com.example.hautomation.models;

import com.example.hautomation._enums.TransactionMode;
import com.example.hautomation._enums.TransactionType;

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
