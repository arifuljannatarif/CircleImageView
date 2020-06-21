/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/24/20 10:04 AM
 */

package com.example.mvc.models;

import com.example.mvc._enums.TransactionMode;
import com.example.mvc._enums.TransactionType;

public class TransactionModel {
    private long Date;
    private long lastUpdated;
    private String entryBy;
    private String userId;
    private boolean payment;
    private  String notes;
    private String bookId;
    private int amount;
    private String title;
    private TransactionType type;

    public TransactionModel(String bookId, int amount, String notes) {
        this.bookId = bookId;
        this.amount = amount;
        this.notes=notes;
    }

    public long getDate() {
        return Date;
    }

    public void setDate(long date) {
        Date = date;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getEntryBy() {
        return entryBy;
    }

    public void setEntryBy(String entryBy) {
        this.entryBy = entryBy;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isPayment() {
        return payment;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
}
