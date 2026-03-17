package Parking;

import Vehicle.Vehicle;

import java.util.List;

public class ParkingLot {
    List<ParkingSlot> parkingSlots;

    public ParkingLot (List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public ParkingSlot findParkingSlot(Vehicle vehicle) {
        for(ParkingSlot spot: parkingSlots) {
            if(!spot.isOccupied && spot.spotType.equalsIgnoreCase(vehicle.getVehicleType())) {
                return spot;
            }
        }

        return null;
    }

    public ParkingSlot parkVehicle(Vehicle vehicle) {
        ParkingSlot parkingSlot = findParkingSlot(vehicle);

        if(parkingSlot != null) {
            parkingSlot.parkVehicle(vehicle);
            System.out.println("Vehicle parked successfully at " +  parkingSlot.getSpotNumber());
            return parkingSlot;
        }

        System.out.println("No slot available for " + vehicle.getVehicleType());
        return null;
    }

    public void vacateSpot(ParkingSlot slot, Vehicle vehicle) {
        if(slot != null && slot.isOccupied && slot.getVehicle().equals(vehicle)) {
            slot.vacate(vehicle);
            System.out.println("Vehicle vacated successfully at" +  slot.getSpotNumber());
        }

        else  {
            System.out.println("Invalid Operation! Either the slot is already empty or vehicle does not match");
        }
    }

    public ParkingSlot getSpotByNumber(int spotNumber) {
        for(ParkingSlot slot: parkingSlots) {
            if(slot.getSpotNumber() == spotNumber) {
                return slot;
            }
        }

        return null;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }
}
