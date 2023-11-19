package com.w1839528.task3;

public class Patient {
    private String firstName;
    private String surName;
    private int age;
    private String city;
    private long idNumber; //NIC or Passport Number
    private String vaccinationType;

    /**
     * Booth 0 & 1: AstraZeneca
     * Booth 2 & 3: Sinopharm
     * Booth 4 & 5: Pfizer
     *
     */

    //Default Constructor
    Patient(){

    }

    //Patient Constructor with parameters
    Patient(String firstName, String surName, int age, String city, long idNumber, String vaccinationType){
        this.firstName = firstName;
        this.surName = surName;
        this.age = age;
        this.city = city;
        this.idNumber = idNumber;
        this.vaccinationType = vaccinationType;
    }

    //Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public String getVaccinationType() {
        return vaccinationType;
    }

    public void setVaccinationType(String vaccinationType) {
        this.vaccinationType = vaccinationType;
    }
}
