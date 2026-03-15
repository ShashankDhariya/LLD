package Vehicle;

import ParkingFee.VehicleFeeStrategy;

public class VehicleFactory {
    public Vehicle createVehicle(String licensePlate, String vehicleType, VehicleFeeStrategy vehicleFeeStrategy) {
        if(vehicleType.equals("Car")){
            return new CarVehicle(licensePlate, vehicleType, vehicleFeeStrategy);
        }

        else if(vehicleType.equals("Bike")){
            return new Bike(licensePlate, vehicleType, vehicleFeeStrategy);
        }

        return new Others(licensePlate, vehicleType, vehicleFeeStrategy);
    }

}
