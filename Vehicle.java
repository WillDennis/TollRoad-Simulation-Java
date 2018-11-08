/*
 * Author : William Dennis
 * Date : 19/04/2018
 * Version : 1.3
 */
package tollroad;

public abstract class Vehicle {

    /*New Attributes for vehicles*/
    private final String registrationPlate;
    private final String vehicleMake;

    /* STANDARD OUTPUTS */
    public Vehicle() {

        this.registrationPlate = " - ";
        this.vehicleMake = " - ";

    }

    /*Contructor with String arguments*/
    public Vehicle(String registrationPlate, String vehicleMake) {
        this.registrationPlate = registrationPlate;
        this.vehicleMake = vehicleMake;
    }

    /*Public Abstract Method*/
    public abstract int calculateBasicTripCost();
    

    /*Accessor Methods*/
    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }
   

}
