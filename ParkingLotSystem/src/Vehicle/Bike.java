package Vehicle;

import ParkingFee.VehicleFeeStrategy;

public class Bike extends Vehicle {

    public Bike(String licensePlate, String vehicleType, VehicleFeeStrategy vehicleFeeStrategy) {
        super(licensePlate, vehicleType, vehicleFeeStrategy);
    }
}
