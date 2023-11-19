package com.w1839528.task3;

public class Booth {
    private int boothNumber;
    private Patient customer;

    //Default Constructor
    public Booth(){

    }

    //Booth constructor with parameters
    public Booth(int boothNumber, Patient customer) {
        this.boothNumber = boothNumber;
        this.customer = customer;
    }

    //Set getters and setters
    public int getBoothNumber() {
        return boothNumber;
    }

    public void setBoothNumber(int boothNumber) {
        this.boothNumber = boothNumber;
    }

    public Patient getCustomer() {
        return customer;
    }

    public void setCustomer(Patient customer) {
        this.customer = customer;
    }



}
