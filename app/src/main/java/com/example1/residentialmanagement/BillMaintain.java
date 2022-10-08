package com.example1.residentialmanagement;

public class BillMaintain {
    private String Month, Year, Amount;

    public BillMaintain() {
    }

    public BillMaintain(String month, String year, String amount) {
        Month = month;
        Year = year;
        Amount = amount;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }
}
