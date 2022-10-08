package com.example1.residentialmanagement;

public class add_member {
    String fname,lname,houseno,type,nomembers;

    public add_member() {
    }

    public add_member(String fname, String lname, String houseno, String type, String nomembers) {
        this.fname = fname;
        this.lname = lname;
        this.houseno = houseno;
        this.type = type;
        this.nomembers = nomembers;
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

    public String getHouseno() {
        return houseno;
    }

    public void setHouseno(String houseno) {
        this.houseno = houseno;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNomembers() {
        return nomembers;
    }

    public void setNomembers(String nomembers) {
        this.nomembers = nomembers;
    }
}
