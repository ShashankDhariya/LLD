package Vehicle;

import ParkingFee.DurationType;
import ParkingFee.VehicleFeeStrategy;

import java.time.Duration;

public abstract class Vehicle {
    String licensePlate;
    String vehicleType;
    VehicleFeeStrategy vehicleFeeStrategy;

    Vehicle(String licensePlate, String vehicleType, VehicleFeeStrategy vehicleFeeStrategy) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.vehicleFeeStrategy = vehicleFeeStrategy;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public VehicleFeeStrategy getVehicleFeeStrategy() {
        return vehicleFeeStrategy;
    }

    public double calculateFee(int duration, DurationType durationType){
        return vehicleFeeStrategy.calcluateFee(vehicleType, duration, durationType);
    }
}

