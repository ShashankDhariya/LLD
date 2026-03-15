package Vehicle;

import ParkingFee.VehicleFeeStrategy;

public class CarVehicle extends Vehicle {
    CarVehicle(String licensePlate, String vehicleType, VehicleFeeStrategy vehicleFeeStrategy) {
        super(licensePlate, vehicleType, vehicleFeeStrategy);
    }
}
