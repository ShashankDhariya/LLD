package Vehicle;

import ParkingFee.VehicleFeeStrategy;

public class Others extends Vehicle {

    Others(String licensePlate, String vehicleType, VehicleFeeStrategy vehicleFeeStrategy) {
        super(licensePlate, vehicleType, vehicleFeeStrategy);
    }
}
