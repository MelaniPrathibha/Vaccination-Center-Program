package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.print.PrinterJob;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Date;

public class Controller {
    @FXML
    private TextField firstName;
    @FXML
    private TextField surname;
    @FXML
    private TextField age;
    @FXML
    private TextField city;
    @FXML
    private TextField idNumber;
    @FXML
    private ChoiceBox<String> vaccinationOptions;
    @FXML
    private ChoiceBox<String> boothNumber;
    @FXML
    private TextArea receiptView;

    public void generateReceipt(){
        receiptView.setText("---------------------------------------------------\n");
        receiptView.setText(receiptView.getText() + "       Covid-19 Vaccination Programme 2021\n");
        receiptView.setText(receiptView.getText() + "                   Patient Receipt\n");
        receiptView.setText(receiptView.getText() + "---------------------------------------------------\n");

        /**
         * generate date-time stamp
         */
        Date date = new Date();
        String dateTime = date.toString();

        /**
         * get values to the text area
         */
        receiptView.setText(receiptView.getText() + "\n" + dateTime + "\n\n");
        receiptView.setText("\n" + receiptView.getText() + "Patient's Name: " + firstName.getText() + " " + surname.getText() + "\n\n");
        receiptView.setText(receiptView.getText() + "Age: " + age.getText() + "\n\n");
        receiptView.setText(receiptView.getText() + "City: " + city.getText() + "\n\n");
        receiptView.setText(receiptView.getText() + "NIC/PS Number: " + idNumber.getText() + "\n\n");
        receiptView.setText(receiptView.getText() + "Vaccination Type: " + vaccinationOptions.getValue() + "\n\n");
        receiptView.setText(receiptView.getText() + "Booth Number: " + boothNumber.getValue() + "\n\n");

        receiptView.setText(receiptView.getText() + "\n---------------------------------------------------\n");
        receiptView.setText(receiptView.getText() + "          THANK YOU FOR GETTING VACCINATED\n");
        receiptView.setText(receiptView.getText() + "      Please Check your Receipt Before Leaving \n");
        receiptView.setText(receiptView.getText() + "---------------------------------------------------\n");

    }

    /**
     * To reset all the data in the form
     */
    public void resetBtn(){
        firstName.clear();
        surname.clear();
        age.clear();
        city.clear();
        idNumber.clear();
        vaccinationOptions.setValue("None");
        boothNumber.setValue("None");
        receiptView.clear();
    }

    /**
     * print receipt
     */
    public void printReceipt(ActionEvent event)throws Exception{
        PrinterJob printer = PrinterJob.createPrinterJob();
        try {
            printer.printPage(receiptView);
        }catch (Exception e){
            System.out.println("System Error");
        }
    }

    public void initialize(){
        /**
         * This is for set values to Vaccination Type ChoiceBox Menu
         */
        vaccinationOptions.getItems().addAll("None", "AstraZeneca", "Sinopharm", "Pfizer");
        vaccinationOptions.setValue("None");

        /**
         * This is for set values to Booth Number ChoiceBox Menu
         */
        boothNumber.getItems().addAll("None", "0", "1", "2", "3", "4", "5");
        boothNumber.setValue("None");

    }
}
