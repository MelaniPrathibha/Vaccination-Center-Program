package com.w1839528.task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        VaccinationCenter vaccinationCenter = new VaccinationCenter();


        boolean isExit = true;
        System.out.println("========================== Welcome ==========================");
        System.out.println("           COVID-19 VACCINATION CENTER Program 2021                ");
        System.out.println();

        // call showMenu methods to display menu
        vaccinationCenter.showMenu();


        while(isExit){
            // creating user input object using scanner
            Scanner user_input = new Scanner(System.in);
            //select option from the menu
            System.out.println();
            System.out.print("Enter the relevant code you want: ");
            String user_res = user_input.nextLine();
            System.out.println("------------------------------------------------------------");

            switch(user_res){
                //Show menu
                case "000":
                case "VMG":
                    vaccinationCenter.showMenu();
                    break;
                // View All 6 booths
                case "100":
                case "VVB":
                    vaccinationCenter.viewAllBooths();
                    break;
                // View only empty booths
                case "101":
                case "VEB":
                    vaccinationCenter.viewEmptyBooths();
                    break;
                // Add patient to a booth
                case "102":
                case "APB":
                    vaccinationCenter.addPatientTOBooth();
                    break;
                // Remove a patient from a booth
                case "103":
                case "RPB":
                    vaccinationCenter.removePatientFromBooth();
                    break;
                // View all the patients' names sorted with alphabetical order
                case "104":
                case "VPS":
                    vaccinationCenter.viewPatients();
                    break;
                // Store data to a file called report.txt
                //  if there's no such a file this a new file will be created
                case "105":
                case "SPD":
                    vaccinationCenter.storeData();
                    break;
                // Load saved data to service center array
                case "106":
                case "LPD":
                    vaccinationCenter.loadData();
                    break;
                // show remaining vaccinations
                case "107":
                case "VRV":
                    vaccinationCenter.remainingVaccinations();
                    break;
                // add vaccinations to the stock
                case "108":
                case "AVS":
                    vaccinationCenter.addVaccinationsToStock();
                    break;
                // Exit from the program
                case "999":
                case "EXT":
                    isExit = false;
                    System.out.println("Thank you!!!!");
                    break;
                default:
                    System.out.println("Invalid Value...");
                    vaccinationCenter.showMenu();
            }
        }
    }
}
