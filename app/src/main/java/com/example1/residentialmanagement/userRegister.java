package com.example1.residentialmanagement;

import com.google.firebase.database.IgnoreExtraProperties;

public class userRegister {
    private String fname,lname,password,mobile_number;



    public userRegister() {
    }

    public userRegister(String fname, String lname, String password, String mobile_number) {
        this.fname = fname;
        this.lname = lname;
        this.password = password;
        this.mobile_number = mobile_number;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }
}
