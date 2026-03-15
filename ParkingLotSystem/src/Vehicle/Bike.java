package Vehicle;

import ParkingFee.VehicleFeeStrategy;

public class Bike extends Vehicle {

    Bike(String licensePlate, String vehicleType, VehicleFeeStrategy vehicleFeeStrategy) {
        super(licensePlate, vehicleType, vehicleFeeStrategy);
    }
}
