import Parking.BikePark;
import Parking.CarPark;
import Parking.ParkingLot;
import Parking.ParkingSlot;
import ParkingFee.BasicRateStrategy;
import ParkingFee.DurationType;
import ParkingFee.PremiumRateStrategy;
import Payment.Card;
import Payment.Cash;
import Payment.PaymentStrategy;
import Vehicle.Vehicle;
import Vehicle.Bike;
import Vehicle.CarVehicle;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<ParkingSlot> parkingSlots = new ArrayList<>();
        parkingSlots.add(new CarPark(1, "CAR"));
        parkingSlots.add(new BikePark(2, "BIKE"));
        parkingSlots.add(new BikePark(3, "BIKE"));
        parkingSlots.add(new CarPark(4, "CAR"));

        ParkingLot parkingLot = new ParkingLot(parkingSlots);

        BasicRateStrategy basicRateStrategy = new BasicRateStrategy();
        PremiumRateStrategy premiumRateStrategy = new PremiumRateStrategy();

        Vehicle bike1 = new Bike("UP11 DD 3940", "Bike",  premiumRateStrategy);
        Vehicle bike2 = new Bike("UP11 DD 3941", "Bike",  basicRateStrategy);
        Vehicle car1 = new CarVehicle("HR60 C 0445", "Car",  premiumRateStrategy);
        Vehicle car2 = new CarVehicle("HR60 C 0441", "Car",  basicRateStrategy);

        ParkingSlot carSlot = parkingLot.parkVehicle(car1);
        ParkingSlot bikeSlot = parkingLot.parkVehicle(bike1);

        if(carSlot != null) {
            double carFee = car1.calculateFee(2, DurationType.Hours);
            PaymentStrategy paymentStrategy = new Card();
            paymentStrategy.processPayment(carFee);
            parkingLot.vacateSpot(carSlot, car1);
        }

        if(bikeSlot != null) {
            double bikeFee = bike1.calculateFee(6, DurationType.Hours);
            PaymentStrategy paymentStrategy = new Cash();
            paymentStrategy.processPayment(bikeFee);
            parkingLot.vacateSpot(bikeSlot, bike1);
        }
    }
}