package Parking;

import Vehicle.Vehicle;

public class BikePark extends ParkingSlot {
    public BikePark(int spotNumber, String spotType) {
        super(spotNumber, spotType);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType().equalsIgnoreCase("Bike") ;
    }
}
