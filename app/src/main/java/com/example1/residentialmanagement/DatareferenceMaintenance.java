package com.example1.residentialmanagement;

public class DatareferenceMaintenance {
    private String month, year, amount;

    public DatareferenceMaintenance() {
    }

    public DatareferenceMaintenance(String month, String year, String amount) {
        this.month = month;
        this.year = year;
        this.amount = amount;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
