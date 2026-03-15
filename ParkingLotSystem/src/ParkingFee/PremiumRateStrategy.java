package ParkingFee;

public class PremiumRateStrategy implements VehicleFeeStrategy{

    @Override
    public double calcluateFee(String vehicle, int duration, DurationType durationType) {
        switch (vehicle.toLowerCase()) {
            case "car":
                return DurationType.Days == durationType?
                        duration * 50 * 24:
                        duration * 50;

            case "bike":
                return DurationType.Days == durationType?
                        duration * 30 * 24:
                        duration * 30;

            case "auto":
                return DurationType.Days == durationType?
                        duration * 15 * 24:
                        duration * 15;

            default:
                return DurationType.Days == durationType?
                        duration * 8 * 100:
                        duration * 100;
        }
    }
}
