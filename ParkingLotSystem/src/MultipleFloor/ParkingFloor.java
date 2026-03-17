package MultipleFloor;

import Parking.ParkingSlot;
import Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    int floor;
    List<ParkingSlot> parkingSlots = new ArrayList<>();

    public ParkingFloor(int floor) {
        this.floor = floor;
        this.parkingSlots = new ArrayList<>();
    }

    public void addParkingSlot(ParkingSlot parkingSlot) {
        parkingSlots.add(parkingSlot);
    }

    public ParkingSlot findAvailableSlots(String vehicle) {
        for(ParkingSlot slot: parkingSlots) {
            if(!slot.isOccupied() && slot.getVehicle().getVehicleType().equalsIgnoreCase(vehicle))
                return slot;
        }
        return null;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public int getFloor() {
        return floor;
    }
}
