package com.example1.residentialmanagement;

public class add_apartment {
   private String name, state, city, address;

    public add_apartment() {
    }

    public add_apartment(String name, String state, String city, String address) {
        this.name = name;
        this.state = state;
        this.city = city;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
