package com.w1839528.task2;

public class Booth {
    private int boothNumber;
    private String customerName;

    // Default constructor
    public Booth(){

    }

    // Booth constructor with parameters
    Booth(int boothNumber, String customerName) {
        this.boothNumber = boothNumber;
        this.customerName = customerName;
    }

    //Set getters and setters

    public int getBoothNumber() {
        return boothNumber;
    }

    public void setBoothNumber(int boothNumber) {
        this.boothNumber = boothNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}
