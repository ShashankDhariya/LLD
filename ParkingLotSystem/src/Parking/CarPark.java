package Parking;

import Vehicle.Vehicle;

public class CarPark extends ParkingSlot {
    public CarPark(int spotNumber, String spotType) {
        super(spotNumber, spotType);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType().equalsIgnoreCase("Car");
    }
}
