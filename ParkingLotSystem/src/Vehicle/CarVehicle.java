package Vehicle;

import ParkingFee.VehicleFeeStrategy;

public class CarVehicle extends Vehicle {
    public CarVehicle(String licensePlate, String vehicleType, VehicleFeeStrategy vehicleFeeStrategy) {
        super(licensePlate, vehicleType, vehicleFeeStrategy);
    }
}
