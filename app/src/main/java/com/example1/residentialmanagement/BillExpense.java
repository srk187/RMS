package com.example1.residentialmanagement;

public class BillExpense {
    private String month,title,amount;

    public BillExpense() {
    }

    public BillExpense(String month, String title, String amount) {
        this.month = month;
        this.title = title;
        this.amount = amount;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
