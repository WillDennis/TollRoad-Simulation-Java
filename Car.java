/*
 * Author : William Dennis
 * Date : 19/04/2018
 * Version : 1.3
 */
package tollroad;

public class Car extends Vehicle {

    private int numberOfSeats;

    @Override
    public String toString() {
        return String.format("\nNumber of Seats: " + numberOfSeats);
    }

    /*Constructor*/
    public Car(String registrationPlate, String vehicleMake, int numberOfSeats) {
        super(registrationPlate, vehicleMake);
        this.numberOfSeats = numberOfSeats;
    }

    //implement abstract method
    @Override
    public int calculateBasicTripCost() {
        //condition for cost based on how many seats in car
        if (numberOfSeats <= 5) {
            return 500;
        } else {
            return 600;
        }
    }
    //Accessor Method for NumofSeats

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    //TESTING MAIN
    public static void main(String[] args) {

        Car c = new Car("LB12VAH", "FORD", 7);
        c.calculateBasicTripCost();
        int i = c.calculateBasicTripCost();
        System.out.println(c + "\nTrip Cost: " + i);
    }

}
