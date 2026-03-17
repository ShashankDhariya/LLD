package Parking;

import Vehicle.Vehicle;

public abstract class ParkingSlot {
    int spotNumber;
    Vehicle vehicle;
    boolean isOccupied;
    String spotType;

    public ParkingSlot(int spotNumber, String spotType) {
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public abstract boolean canParkVehicle(Vehicle vehicle);

    public boolean parkVehicle(Vehicle vehicle) {
        if(isOccupied) {
            throw new IllegalStateException("Parking is already occupied");
        }

        if(!canParkVehicle(vehicle)) {
            throw new IllegalStateException("Parking is not allowed to park this vehicle");
        }

        this.vehicle = vehicle;
        this.isOccupied = true;

        return true;
    }

    public void vacate(Vehicle vehicle) {
        if(!isOccupied) {
            throw new IllegalStateException("Parking is already vacant");
        }

        this.vehicle = null;
        this.isOccupied = false;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public String getSpotType() {
        return spotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}

