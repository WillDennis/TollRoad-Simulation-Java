/*
 * Author : William Dennis
 * Date : 19/04/2018
 * Version : 1.3
 */
package tollroad;
public class Van extends Vehicle {

    /*Amount of Cargo in kg*/
    private int payload;

    /*Constructor*/
    public Van(String registrationPlate, String vehicleMake, int payload) {
        super(registrationPlate, vehicleMake);
        this.payload = payload;
    }

    @Override
    public String toString() {
        return String.format("\nPayload (kg): " + payload);
    }

    //Implement Abstract Method
    @Override //calculateBasicTripCost
    public int calculateBasicTripCost() {
        if (payload <= 600) {
            return 500;
        } else if (payload > 600 && payload <= 800) {
            return 750;
        } else {
            return 1000;
        }
    }

    public int getPayload() {
        return payload;
    }

    public void setPayload(int payload) {
        this.payload = payload;
    }
    //TESTING MAIN

    public static void main(String[] args) {

        Van v = new Van("FR98JKL", "VOLKSWAGON", 200);
        v.calculateBasicTripCost();
        int i = v.calculateBasicTripCost();
        System.out.println(v + "\nTrip Cost: " + i);
    }
}
