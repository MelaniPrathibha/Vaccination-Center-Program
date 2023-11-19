package com.w1839528;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    // define the service center array
    private static String[] serviceCenter = new String[6];

    //define tokenNum to count vaccines
    private static int tokenNum = 150;

    public static void main(String[] args) {
        boolean isExit = true;
        System.out.println("========================== Welcome ==========================");
        System.out.println("           COVID-19 VACCINATION CENTER Program 2021                ");
        System.out.println();

        // call showMenu methods to display menu
        showMenu();

        // set all booth to empty
        initialise(serviceCenter);

        while(isExit){
            // creating user input object using scanner
            Scanner userInput = new Scanner(System.in);
            //select option from the menu
            System.out.print("Enter the relevant code you want: ");
            String userRes = userInput.nextLine();

            switch(userRes){
            //show menu
                case "000":
                case "VMG":
                    showMenu();
                    break;
            // View all 6 booths
                case "100":
                case "VVB":
                    viewAllBooths();
                    break;
            //View all empty booths
                case "101":
                case "VEB":
                    viewEmptyBooths();
                    break;
            // Add patient to a booth
                case "102":
                case "APB":
                    addPatientTOBooth();
                    break;
            // Remove patient from a booth
                case "103":
                case "RPB":
                    removePatientFromBooth();
                    break;
            // View all the patients' names sorted with alphabetical order
                case "104":
                case "VPS":
                    viewPatients();
                    break;
            // Store data to a file called report.txt
            // if there's no such a file this a new file will be created
                case "105":
                case "SPD":
                    storeData();
                    break;
            // Load saved data to service center array
                case "106":
                case "LPD":
                    loadData();
                    break;
            // show remaining vaccinations
                case "107":
                case "VRV":
                    remainingVaccinations();
                    break;
            // add vaccinations to the stock
                case "108":
                case "AVS":
                    addVaccinationsToStock();
                    break;
            // Exit from the program
                case "999":
                case "EXT":
                    isExit = false;
                    System.out.println("Thank you!!!!");
                    break;
            // invalid value
                default:
                    System.out.println("Invalid Value...");
                    showMenu();
            }
        }

    }

    //define method to display Menu
    private static void showMenu(){
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

    //Set all booths empty
    private static void initialise( String[] hotelRef ) {
        for (int x = 0; x < 6; x++ ) hotelRef[x] = "e";
    }

    //Add patient to booth method
    public static void addPatientTOBooth(){
        int boothNum = 0;
        String customerName;
        Scanner input = new Scanner(System.in);
        boolean isExit = true;

        //check whether user entered input is integer or not
        while (isExit) {
        // program will run until user enter a integer as an input for booth number
            try {
                while (boothNum < 6 ){
                    for (int x = 0; x < 6; x++ ) {
                        if (serviceCenter[x].equals("e"))
                            System.out.println("booth " + x + " is empty");
                    }
                    System.out.println("-------------------------------------------------------------");

                // this loop will execute until user enter a valid booth number
                    do {
                        System.out.print("Enter booth number (0-5) or 6 to stop : ");
                        boothNum = input.nextInt();
                    } while (boothNum<0 || boothNum>6);

                // get customer name
                    if (boothNum!=6){
                        System.out.print("Enter customer name for booth " + boothNum +" : " ) ;
                        customerName = input.next();
                        //Count Vaccinations
                        tokenNum = tokenNum - 1;
                        //Display warning message if vaccinations less than or equals 20
                        warningMessage();

                        //Add customerName to service center array
                        serviceCenter[boothNum] = customerName ;
                        for (int x = 0; x < 6; x++ ) {
                            if (!serviceCenter[x].equals("e")){
                                System.out.println("booth " + x + " occupied by " + serviceCenter[x]);
                            }
                        }
                        System.out.println();
                    } else {
                        System.out.println("Exit . . .");
                        isExit = false;
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

    //View all booths
    private static void viewAllBooths(){
        for (int x = 0; x < 6; x++ ) {
            if (serviceCenter[x].equals("e")) System.out.println("booth " + x + " is empty");
            if (!serviceCenter[x].equals("e")) {
                System.out.println("booth " + x + " occupied by " + serviceCenter[x]);
            }
        }
    }

    //View empty booths
    private static void viewEmptyBooths() {
        for (int x = 0; x < 6; x++) {
            if (serviceCenter[x].equals("e"))
                System.out.println("booth " + x + " is empty");
        }
    }

    //Remove Patients from booth
    private static void removePatientFromBooth(){
    // ask from user to enter the relevant booth number which user wants to remove a patient and remove it
        Scanner input = new Scanner(System.in);
        while (true) {
            try {       // check whether user has entered a valid input
                System.out.print("From which booth do you want to remove a patient? ");
                int remove = input.nextInt();
                System.out.println("------------------------------------------------");

                if (remove<0 || remove>6) { //Get valid input
                    System.out.println("Invalid input . . . ");
                    break;
                }

                //check whether the user entered booth number is already empty or not
                if (serviceCenter[remove].equals("e")) {
                    System.out.println("booth " + remove + " is already empty");
                } else {
        // remove current value from that booth and set it to empty
                    serviceCenter[remove] = "e";
                    System.out.println("booth " + remove + " data successfully removed");
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
    private static void viewPatients(){

        boolean isSwapped = false;
        String[] tempServiceCenter = new String[6];
        // copy original array to temp array
        System.arraycopy(serviceCenter, 0, tempServiceCenter, 0, serviceCenter.length);
        // this loop will run until it compares all the objects in both arrays and set it to correct order
        do {
            isSwapped = false;
            for(int i = 0;i < tempServiceCenter.length-1; i++){
                //Compare each objects in the array
                if(tempServiceCenter[i].compareTo(tempServiceCenter[i+1])>0){
                    String temp = tempServiceCenter[i+1];
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
            if (!tempServiceCenter[i].equals("e")) {
                System.out.println(tempServiceCenter[i]);
            }
        }
        //print new line
        System.out.println();

    }

    //View remaining number of vaccinations
    private static void remainingVaccinations(){
        System.out.println("Remaining Vaccinations in the Store: " + tokenNum);
        warningMessage();
    }

    //create a method to display warning message if vaccinations less than or equal 20
    private static void warningMessage() {
        if (tokenNum <= 20){
            System.out.println("WARNING!!!");
        }
    }

    //Add Vaccinations to the stock
    private static void addVaccinationsToStock() {
    // count used vaccinations
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
                        tokenNum += vaccinationAmount;  //update vaccination amount
                        System.out.println("Vaccination Restocked by " + agentName);
                        remainingVaccinations();
                    }
                }catch (InputMismatchException e){
                    System.out.println("Invalid information!!! \nTry again . . .");
                }
            } while (vaccinationAmount > restock);

        }

    }

    //Store current details into a text file
    private static void storeData(){
        //creates report.txt file if it doesn't exits
        //report.txt : readable file
        try {
            File file = new File("report.txt");
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
            }else {
                System.out.println("File already exists.");
            }
        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //Save data to the file
        try {
            FileWriter fileWriter = new FileWriter("report.txt");
            for (int i = 0; i< serviceCenter.length; i++) {
                //print booth data line by line in text file
                fileWriter.write(serviceCenter[i] + "\n");
            }
            fileWriter.close(); //close file connection

            System.out.println("Data Successfully added.");
        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //Load saved data into ServiceCenter array and display data
    private static void loadData() {
        //load data from report.txt to console and serviceCenter array
        try {
            File file = new File("report.txt");
            Scanner input = new Scanner(file);
            int index = 0;
            int tokenCount = 0;
            while (input.hasNextLine()){
                String data = input.nextLine();
                serviceCenter[index] = new String(data);
                System.out.println(data);
                index++;

                if (!data.equals("e")){
                    tokenCount++;
                }
            }
        // vaccination count will update according to the loaded data
            tokenNum = tokenNum - tokenCount;
            System.out.println("Vaccination Count Updated: " + tokenNum);
            input.close();
        }catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
