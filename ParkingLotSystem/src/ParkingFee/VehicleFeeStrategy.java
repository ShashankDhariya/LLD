package ParkingFee;

import Vehicle.Vehicle;

public interface VehicleFeeStrategy {
    double calcluateFee(String vehicle, int duration, DurationType durationType);
}

