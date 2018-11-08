/*
 * Author : William Dennis
 * Date : 19/04/2018
 * Version : 1.3
 */
package tollroad;

import java.util.*;

public class TollRoad {

    private ArrayList<CustomerAccount> customerAccounts = new ArrayList<>();
    private int moneyMade;

    @Override
    public String toString() {
        return String.format("Money Made:  " + moneyMade);
    }

    public TollRoad() {
        customerAccounts = new ArrayList<>();
        moneyMade = 0;
    }

    public void addCustomer(CustomerAccount acc) {
        customerAccounts.add(acc);
    }

    public CustomerAccount findCustomer(String regNum) throws CustomerNotFoundException {
        for (int i = 0; i < customerAccounts.size(); i++) {
            if (customerAccounts.get(i).getVehicle().getRegistrationPlate().equals(regNum)) {
                return customerAccounts.get(i);
            }
        }
        throw new CustomerNotFoundException(regNum);
    }

    public void chargeCustomer(String registrationNumber) throws CustomerNotFoundException, InsufficientAccountBalanceException {
        try {
            moneyMade += findCustomer(registrationNumber).maketrip();
        } catch (InsufficientAccountBalanceException e) {
            throw new InsufficientAccountBalanceException(registrationNumber);
        } catch (CustomerNotFoundException e) {
            throw new CustomerNotFoundException(registrationNumber);
        }
    }

    public int getmoneyMade() {
        return moneyMade;
    }

    public ArrayList<CustomerAccount> getCustomerAccounts() {
        return customerAccounts;
    }
    public static void main(String[] args) {
        TollRoad tollroad1 = new TollRoad();
        Van van1 = new Van("asdfsd", "esdaf", 700);
        Car car1 = new Car("sdaf", "aqwe",4);
        CustomerAccount tar = new CustomerAccount("jsdg", "sdaggasd", 0, van1);
        CustomerAccount tar2 = new CustomerAccount("yeet", "asdasd", 1000, van1);
        tollroad1.addCustomer(tar2);
        try {
            tollroad1.chargeCustomer("asdfsd");
        } catch (CustomerNotFoundException | InsufficientAccountBalanceException ex) {
            System.out.println(ex);
        }
    }

}
