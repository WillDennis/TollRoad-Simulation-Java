/*
 * Author : William Dennis
 * Date : 19/04/2018
 * Version : 1.3
 */
package tollroad;

enum discountType {
    NONE, STAFF, FRIENDS_AND_FAMILY
};

public class CustomerAccount implements Comparable<Vehicle> {

    //Initialising Attributes
    private final String firstName;
    private final String lastName;
    private int accountBalance;
    private discountType DiscountType = discountType.NONE;
    private Vehicle vehicle;

    //Default Account Fields
    public CustomerAccount() {
        firstName = " - ";
        lastName = " - ";
        accountBalance = 0;
        vehicle = vehicle;
    }
//constructor

    public CustomerAccount(String firstName, String lastName, int accountBalance, Vehicle vehicle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountBalance = accountBalance;
        this.vehicle = vehicle;
    }

    public void activateStaffDiscount() {
        DiscountType = discountType.STAFF;
    }

    public void activateFriendsAndFamilyDiscount() {
        DiscountType = discountType.FRIENDS_AND_FAMILY;
    }

    public void deactivateDiscount() {
        DiscountType = discountType.NONE;
    }

    public void addFunds(int amount) {
        accountBalance += amount;
    }

    public int maketrip() throws InsufficientAccountBalanceException {
        int fare;
        fare = vehicle.calculateBasicTripCost();
        if (DiscountType == discountType.STAFF) {
            fare = (int) (fare * 0.5);

        } else if (DiscountType == discountType.FRIENDS_AND_FAMILY) {
            fare = (int) (fare * 0.9);
        }

        actualBalance(accountBalance, fare);

        accountBalance -= fare;
        return fare;
    }

    public int actualBalance(int currentBalance, int fare)
            throws InsufficientAccountBalanceException {

        if (currentBalance < fare) {
            throw new InsufficientAccountBalanceException(" ");
        } else {
            return currentBalance;
        }
    }

    @Override
    public int compareTo(Vehicle vehicle2) {
        String veh2Reg = vehicle2.getRegistrationPlate();
        if (vehicle.getRegistrationPlate().compareTo(veh2Reg) > 0) {
            return 1;
        } else if (vehicle.getRegistrationPlate().compareTo(veh2Reg) == 0) {
            return 0;
        } else {
            return -1;

        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAccountBal() {
        return accountBalance;
    }

    public void setAccountBal(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public discountType getDiscount() {
        return DiscountType;
    }

    public static void main(String[] args) {
        Van van1 = new Van("asdfsd", "esdaf", 700);
        Car car1 = new Car("sdaf", "aqwe", 4);
        CustomerAccount tar = new CustomerAccount("jsdg", "sdaggasd", 2341, van1);
        CustomerAccount tar2 = new CustomerAccount("yeet", "asdasd", 9721, van1);
        System.out.println(tar.compareTo(car1));

    }

}
