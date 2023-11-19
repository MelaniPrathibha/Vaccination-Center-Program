package com.w1839528.task3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class VaccinationCenter {
    // define the service center array
    private static final Booth[] serviceCenter = new Booth[6];

    public VaccinationCenter(){
        // set all booth to empty
        initialise(serviceCenter);
    }

    //define token_Num to count vaccines
    private int tokenNum = 150;

    //define method to display Menu
    public void showMenu(){
        System.out.println("=========================== Menu ============================");
        System.out.println("000 or VMG : View Menu Again");
        System.out.println("100 or VVB : View all Vaccination Booths");
        System.out.println("101 or VEB : View all Empty Booths");
        System.out.println("102 or APB : Add Patient to a Booth");
        System.out.println("103 or RPB : Remove Patient from a Booth");
        System.out.println("104 or VPS : View Patients Sorted in alphabetical order");
        System.out.println("105 or SPD : Store Program Data into file");
        System.out.println("106 or LPD : Load Program Data from file");
        System.out.println("107 or VRV : View Remaining Vaccinations");
        System.out.println("108 or AVS : Add Vaccinations to the Stock");
        System.out.println("999 or EXT : Exit the Program");
        System.out.println("=============================================================");
    }

    //View all booths
    public void viewAllBooths(){
        for (int x = 0; x < 6; x++ ) {
            if (serviceCenter[x].getCustomer().getFirstName().equals("e")) System.out.println("booth " + x + " is empty");
            if (!serviceCenter[x].getCustomer().getFirstName().equals("e")) {
                System.out.println("booth " + x + " occupied by " + serviceCenter[x].getCustomer().getFirstName());
            }
        }
    }

    //View empty booths
    public void viewEmptyBooths() {
        for (int x = 0; x < 6; x++) {
            if (serviceCenter[x].getCustomer().getFirstName().equals("e"))
                System.out.println("booth " + x + " is empty");
        }
    }

    //Add patient to booth method
    public void addPatientTOBooth(){
        int boothNum = 0;
        Scanner input = new Scanner(System.in);
        boolean isExit = true;

        //check whether user entered input is integer or not
        while (isExit) {

//            program will run until user enter a integer as an input for booth number
            try {
                while (boothNum < 6 ){

                    //      Add Patient's details
                    System.out.println("............. Patient's Details ................");
                    //  first name
                    System.out.print("First Name: ");
                    String firstName = input.next();
                    // last name
                    System.out.print("Last Name: ");
                    String surName = input.next();
                    // city
                    System.out.print("City: ");
                    String city = input.next();

                    // Vaccination Type
                    //Created array for vaccination types
                    String[] vaccinationTypeArr = {"AstraZeneca" , "Sinopharm" , "Pfizer"};

                    boolean isValid = false;
                    String vaccinationType;

                    System.out.println("Available Vaccination Types");
                    System.out.println("    AstraZeneca");
                    System.out.println("    Sinopharm");
                    System.out.println("    Pfizer");

                    //get vaccination type until user enter a valid input
                    do{
                        System.out.print("Requested Vaccination Type: ");
                        vaccinationType = input.next();
                        for (int i = 0; i < vaccinationTypeArr.length; i++){
                            if (vaccinationType.equals(vaccinationTypeArr[i])){
                                isValid = true;
                            }
                        }
                    } while (!isValid);

                    // Nic or Passport number
                    System.out.print("NIC or Passport Number: ");
                    long idNumber = input.nextLong();
                    //age
                    System.out.print("Age: ");
                    int age = input.nextInt();

                    Patient patient = new Patient(firstName,surName,age,city,idNumber,vaccinationType);

                    for (int x = 0; x < 6; x++ ) {
                        if (serviceCenter[x].getCustomer().getFirstName().equals("e"))
                            System.out.println("booth " + x + " is empty");
                    }
                    System.out.println("-------------------------------------------------------------");

                    switch (patient.getVaccinationType()) {
                        case "AstraZeneca":
                            do {
                                System.out.print("Enter booth number (0-1) or 6 to stop : ");
                                boothNum = input.nextInt();
                                if (boothNum==6){
                                    break;
                                }
                            }while (boothNum<0 || boothNum>1 );
                            break;
                        case "Sinopharm":
                            do {
                                System.out.print("Enter booth number (2-3) or 6 to stop : ");
                                boothNum = input.nextInt();
                                if (boothNum==6){
                                    break;
                                }
                            } while (boothNum<2 || boothNum>3 );
                            break;
                        case "Pfizer":
                            do {
                                System.out.print("Enter booth number (4-5) or 6 to stop : ");
                                boothNum = input.nextInt();
                                if (boothNum==6){
                                    break;
                                }
                            } while (boothNum<4 || boothNum>5);
                            break;
                    }


                    //get customer name
                    if (boothNum != 6) {

                        //Count Vaccinations
                        tokenNum = tokenNum - 1;
                        //Display warning message if vaccinations less than or equals 20
                        warningMessage();
                        //Create Object
                        Booth booth = new Booth(boothNum, patient);
                        //Add customerName to service center array
                        serviceCenter[boothNum] = booth;
                        for (int x = 0; x < 6; x++) {
                            if (!serviceCenter[x].getCustomer().getFirstName().equals("e")) {
                                System.out.println("booth " + x + " occupied by " + serviceCenter[x].getCustomer().getFirstName());
                            }
                        }
                        System.out.println();

                    } else {
                        System.out.println("Exit . . .");
                        isExit = false;
                    }
                    System.out.print("Do you want to add more Patients?(y/n) : ");
                    String choice = input.next();
                    if (choice.equals("n") || choice.equals("N")){
                        break;
                    }
                }
            } catch (InputMismatchException e){
                System.out.println("Invalid Input.....\nPlease enter an valid integer");
                input.next();
                continue;
            }
            break;
        }
    }

    //Remove Patients from booth
    public void removePatientFromBooth(){
    //ask from user to enter the relevant booth number which user wants to remove a patient and remove it
        Scanner input = new Scanner(System.in);
        while (true) {
            try {   // check whether user has entered a valid input
                System.out.print("From which booth do you want to remove a patient? ");
                int remove = input.nextInt();
                System.out.println("------------------------------------------------");

                if (remove<0 || remove>6) { //Get valid input
                    System.out.println("Invalid input . . . ");
                    break;

                } else {
                    //check whether the user entered booth number is already empty or not
                    if (serviceCenter[remove].getCustomer().getFirstName().equals("e")) {
                    // if that booth is already empty an alert message will be displayed
                        System.out.println("booth " + remove + " is already empty");
                    } else {

                        // remove current value from that booth and set it to empty

                        serviceCenter[remove].getCustomer().setFirstName("e");
                        System.out.println("booth " + remove + " data successfully removed");
                    }
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid Input.....\nPlease enter an valid input");
                input.next();
                continue;
            }
            break;
        }
    }

    //View Patients Sorted in alphabetical order
    public void viewPatients(){

        boolean isSwapped;
        Booth[] tempServiceCenter = new Booth[6];
        // copy original array to tempServiceCenter array
        System.arraycopy(serviceCenter, 0, tempServiceCenter, 0, serviceCenter.length);
        // this loop will run until it compares all the objects in both arrays and set it to correct order
        do {
            isSwapped = false;
            for(int i = 0;i < tempServiceCenter.length-1; i++){
                if(tempServiceCenter[i].getCustomer().getFirstName().compareTo(tempServiceCenter[i+1].getCustomer().getFirstName())>0){
                    Booth temp = tempServiceCenter[i+1];
                    tempServiceCenter[i+1] = tempServiceCenter[i];
                    tempServiceCenter[i] = temp;
                    isSwapped = true;
                }
            }
        }while((isSwapped));
        // print alphabetical order
        System.out.println("====== Patients Sorted in alphabetical order ======");
        System.out.println();
        for (int i = 0; i < tempServiceCenter.length; i++) {
            if (!tempServiceCenter[i].getCustomer().getFirstName().equals("e")) {
                System.out.println(tempServiceCenter[i].getCustomer().getFirstName());
            }
        }
        System.out.println();

    }

    //Store current data into a txt file
    public void storeData(){
        //creates report2.txt file if it doesn't exits
        //report2.txt : for user
        try {
            File file = new File("report2.txt");
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
            }else {
                System.out.println("File already exists.");
            }
        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter fileWriter = new FileWriter("report2.txt");
            for (int i = 0; i< serviceCenter.length; i++) {
                String[] temp = new String[6];
                temp[0] = serviceCenter[i].getCustomer().getFirstName();
                temp[1] = serviceCenter[i].getCustomer().getSurName();
                temp[2] = String.valueOf(serviceCenter[i].getCustomer().getAge());
                temp[3] = serviceCenter[i].getCustomer().getCity();
                temp[4] = String.valueOf(serviceCenter[i].getCustomer().getIdNumber());
                temp[5] = serviceCenter[i].getCustomer().getVaccinationType();

                fileWriter.write( temp[0] +"," + temp[1] + ","  + temp[2] + "," + temp[3] + "," + temp[4] + "," + temp[5] + "\n");
            }
            fileWriter.close(); //close file connection

            System.out.println("Data Successfully added.");
        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //Load data from the file
    public void loadData() {
        //load data from report2.txt to console and serviceCenter array
        try {
            File file = new File("report2.txt");
            Scanner input = new Scanner(file);
            int index = 0;
            int tokenCount = 0;
            while (input.hasNextLine()){
                String data = input.nextLine();
                String[] temp = data.split(",");
                String firstName = temp[0];
                String surName = temp[1];
                int age = Integer.parseInt(temp[2]);
                String city = temp[3];
                long idNumber = Long.parseLong(temp[4]);
                String vaccinationType = temp[5];

                Patient patient = new Patient(firstName, surName, age, city, idNumber, vaccinationType);

                serviceCenter[index] = new Booth(index,patient);
                System.out.println(data);
                index++;

                if (!temp[0].equals("e")){
                    tokenCount++;
                }
            }
            //vaccination count will update according to the loaded data
            tokenNum = tokenNum - tokenCount;
            System.out.println("Vaccination Count Updated: " + tokenNum);
            input.close();
        }catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //View remaining number of vaccinations
    public void remainingVaccinations(){
        System.out.println("Remaining Vaccinations in the Store: " + tokenNum);
        warningMessage();
    }

    //Add Vaccinations to the stock
    public void addVaccinationsToStock() {
        //count used vaccinations
        int restock = 150 - tokenNum;
        Scanner input = new Scanner(System.in);
        int vaccinationAmount = 0;
        // check whether it is needed to restock or not
        if (restock == 0) {
            System.out.println("No need to restock.");
        }else {

        //show maximum vaccinations need to restock
            System.out.print("Maximum vaccinations need to restock: " + restock);
            System.out.println();

            System.out.print("Agent Name : ");
            String agentName = input.nextLine();

            // check agent entered vaccination amount is less than or equals to the required amount
                do {
                    try {
                        System.out.println("Maximum vaccinations need to restock: " + restock);
                        System.out.print("Vaccination Amount : ");
                        vaccinationAmount = input.nextInt();
                        if (vaccinationAmount <= restock) {
                            tokenNum += vaccinationAmount;
                            System.out.println("Vaccination Restocked by " + agentName);
                            remainingVaccinations();
                        }
                    }catch (InputMismatchException e){
                        System.out.println("Invalid information!!! \nTry again . . .");
                    }
                } while (vaccinationAmount > restock);
            }

        }

    //Set all booths empty
    public void initialise(Booth[] hotelRef) {
        Patient patient = new Patient();
        for (int x = 0; x < 6; x++ ){
            hotelRef[x] = new Booth(x,patient);
            hotelRef[x].getCustomer().setFirstName("e");
        }
    }

    //create a method to display warning message if vaccinations less than or equal 20
    private void warningMessage() {
        if (tokenNum <= 20){
            System.out.println("WARNING!!!");
        }
    }

}

