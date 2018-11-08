/*
 * Author : William Dennis
 * Date : 19/04/2018
 * Version : 1.3
 */
package tollroad;

import java.io.*;
import java.util.Scanner;

public class TollRoadMain {

    public TollRoad initialiseTollRoadFromFile() {
        //initialise variables
        String vehicleType, registrationNum, firstName, lastName, vehicleMake;
        int vehicleInfo, startingBalance;
        String discountType;
        //initialising tollroad 
        TollRoad tollroad = new TollRoad();
        //initialising file customerData and giving it a name readFile.
        File readFile = new File("./src/tollroad/customerData.txt");

        try {

            //Reading in using Scanner method
            //Initialise Scanner Object
            Scanner customerData = new Scanner(readFile);

            //Initialise String Delimiter
            //"#" tells Scanner to match a # as a delimiter.
            customerData.useDelimiter("#");

            while (customerData.hasNext()) {
                //initialising scanner object
                Scanner commaScanner = new Scanner(customerData.next());
                //setting scanner to use delimiter "," to read through larger scanned object.
                commaScanner.useDelimiter(",");
                //assigning of next scanned in using commaScanner to variable names
                vehicleType = commaScanner.next();
                // System.out.println(vehicleType);
                registrationNum = commaScanner.next();
                // System.out.println(registrationNum);
                firstName = commaScanner.next();
                // System.out.println(firstName);
                lastName = commaScanner.next();
                // System.out.println(lastName);
                vehicleMake = commaScanner.next();
                // System.out.println(vehicleMake);
                vehicleInfo = Integer.parseInt(commaScanner.next());
                // System.out.println(vehicleInfo);
                startingBalance = Integer.parseInt(commaScanner.next());
                // System.out.println(startingBalance);
                discountType = commaScanner.next();
                //  System.out.println(discountType);
                
                //If loop for vehicleType of Car.
                if ("Car".equals(vehicleType)) {
                    //Creating car object and giving it constructors from classes.
                    Car car = new Car(registrationNum, vehicleMake, vehicleInfo);
                    //creating a new customerAccount with constructors from CustomerAccount class.
                    CustomerAccount ca = new CustomerAccount(firstName, lastName, startingBalance, car);
                    //Discount types applied
                    if ("STAFF".equals(discountType)) {
                        //calling respecitve method from CustomerAccount class.
                        ca.activateStaffDiscount();
                    } else if ("FRIENDS_AND_FAMILY".equals(discountType)) {
                        //calling respecitve method from CustomerAccount class.
                        ca.activateFriendsAndFamilyDiscount();
                    } else if ("NONE".equals(discountType)) {
                        //calling respecitve method from CustomerAccount class.
                        ca.deactivateDiscount();
                    }
                    tollroad.getCustomerAccounts().add(ca);

                } else if ("Van".equals(vehicleType)) {
                    //Creating Van object and giving it constructors from classes.
                    Van van = new Van(registrationNum, vehicleMake, vehicleInfo);
                    //creating a new customerAccount with constructors from CustomerAccount class.
                    CustomerAccount ca = new CustomerAccount(firstName, lastName, startingBalance, van);
                    //Discount types applied
                    if ("STAFF".equals(discountType)) {
                        //calling respecitve method from CustomerAccount class.
                        ca.activateStaffDiscount();
                    } else if ("FRIENDS_AND_FAMILY".equals(discountType)) {
                        //calling respecitve method from CustomerAccount class.
                        ca.activateFriendsAndFamilyDiscount();
                    } else if ("NONE".equals(discountType)) {
                        //calling respecitve method from CustomerAccount class.
                        ca.deactivateDiscount();
                    }
                    tollroad.getCustomerAccounts().add(ca);
                }
                if ("Truck".equals(vehicleType)) {
                    //Creating Truck object and giving it constructors from classes.
                    Truck truck = new Truck(registrationNum, vehicleMake, vehicleInfo);
                    //creating a new customerAccount with constructors from CustomerAccount class.
                    CustomerAccount ca = new CustomerAccount(firstName, lastName, startingBalance, truck);
                    //Discount types applied
                    if ("STAFF".equals(discountType)) {
                        //calling respecitve method from CustomerAccount class.
                        ca.activateStaffDiscount();
                    } else if ("FRIENDS_AND_FAMILY".equals(discountType)) {
                        //calling respecitve method from CustomerAccount class.
                        ca.activateFriendsAndFamilyDiscount();
                    } else if ("NONE".equals(discountType)) {
                        //calling respecitve method from CustomerAccount class.
                        ca.deactivateDiscount();
                    }
                    tollroad.getCustomerAccounts().add(ca);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return tollroad;
    }

    //Simulate from file method
    public static void simulateFromFile(TollRoad road) throws InsufficientAccountBalanceException, CustomerNotFoundException, IOException {
        //Read in File from directory
        File transaction = new File(".\\src\\tollroad\\transactions.txt");
        //try and catch to read in file 
        try {
            //intialising scanner and setting delimiter to break file into statements.
            Scanner scan = new Scanner(transaction);
            scan.useDelimiter("\\$");
            //condition to allow to file read in next.
            while (scan.hasNext()) {
                //setting string called line for read in text.
                String line = scan.next();
                //splitting the string by its commas.
                String[] split = line.split(",");
                //switch case to sort between maketrip and add funds statements.
                switch (split[0].toLowerCase()) {
                    //maketrip case
                    case "maketrip":
                        try {
                            road.chargeCustomer(split[1]);
                            //charging customer if they have the right funds.
                            System.out.println(String.format("%s: Trip completed successfully", split[1]));
                            
                            //Testing Money made is working 
                            //System.out.println("Current Money" + road.getmoneyMade());
                            
                            //catch to send exception message if customer doesn't have sufficient funds.
                        } catch (InsufficientAccountBalanceException e) {
                            System.out.println(String.format("%s: makeTrip failed. Insufficient funds.", split[1]));
                            //catch to send exception message if customer account doesn't exist.
                        } catch (CustomerNotFoundException e) {
                            System.out.println(String.format("%s: makeTrip failed. CustomerAccount does not exist.", split[1]));
                        }
                        break;
                    //Addfunds case
                    case "addfunds":
                        try {
                            //Initialising customerAccount called acc and the finding the customer account with the respectve reg.
                            CustomerAccount acc = road.findCustomer(split[1]);
                            //assigning funds from file to int amount.
                            int amount = Integer.parseInt(split[2]);
                            //adding funds to the customers account
                            acc.addFunds(amount);
                            //success output message with amount and RegNum.
                            System.out.println(String.format("%s: %d Funds added.", split[1], amount));
                        } catch (CustomerNotFoundException e) {
                            //exception message if the customer account cannot be found.
                            System.out.println(String.format("%s: CustomerAccount does not exist", split[1]));
                        }
                        break;
                }
            }
        //catch for if the file was not found.
        } catch (FileNotFoundException e) {
            System.out.println(e);

        }
    }
    //main method to run program
    public static void main(String[] args) {
        //creating new main called tr
        TollRoadMain tr = new TollRoadMain();
        //creating a new tollroad called to and running the initialiseTollRoadFromFile method.
        TollRoad to = tr.initialiseTollRoadFromFile();
        //try catch needed to catch exceptions for method simulateFromFile.
        try {
            //running simulateFromFile method.
            TollRoadMain.simulateFromFile(to);
        } catch (InsufficientAccountBalanceException | CustomerNotFoundException | IOException ex) {
            System.out.println(ex);
        }
        //output the moneyMade by Tollroad.
        System.out.println("Money Made: " + to.getmoneyMade());

    }
}
