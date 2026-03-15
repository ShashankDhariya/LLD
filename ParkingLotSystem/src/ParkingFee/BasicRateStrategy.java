package ParkingFee;
import Vehicle.Vehicle;

public class BasicRateStrategy implements VehicleFeeStrategy{

    @Override
    public double calcluateFee(String vehicle, int duration, DurationType durationType) {
        switch (vehicle.toLowerCase()) {
            case "car":
                return DurationType.Days == durationType?
                        duration * 25 * 24:
                        duration * 25;

            case "bike":
                return DurationType.Days == durationType?
                        duration * 15 * 24:
                        duration * 15;

            case "auto":
                return DurationType.Days == durationType?
                        duration * 8 * 24:
                        duration * 8;

            default:
                return DurationType.Days == durationType?
                        duration * 8 * 50:
                        duration * 50;
        }
    }
}
