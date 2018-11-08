/*
 * Author : William Dennis
 * Date : 19/04/2018
 * Version : 1.3
 */
package tollroad;

public class Truck extends Vehicle {

    /*Amount of Trailers*/
    private int numTrailers;

    /*Constructor*/
    public Truck(String registrationPlate, String vehicleMake, int numTrailers) {
        super(registrationPlate, vehicleMake);
        this.numTrailers = numTrailers;
    }

    //return output for 
    @Override
    public String toString() {
        return String.format("\nNumber of Trailers: " + numTrailers);
    }

    //Implement Abstract Method
    @Override
    public int calculateBasicTripCost() {
        if (numTrailers < 2) {
            return 1250;
        } else {
            return 1500;
        }
    }
    //Accessor Method for numTrailers

    public int getNumTrailers() {
        return numTrailers;
    }

    public void setNumTrailers(int numTrailers) {
        this.numTrailers = numTrailers;
    }
    //TESTING MAIN

    public static void main(String[] args) {

        Truck t = new Truck("PQ32GNF", "Mercedes", 0);
        t.calculateBasicTripCost();
        int i = t.calculateBasicTripCost();
        System.out.println(t + "\nTrip Cost: " + i);
    }

}
