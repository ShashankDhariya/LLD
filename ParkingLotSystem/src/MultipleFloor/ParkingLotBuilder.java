package MultipleFloor;

import Parking.BikePark;
import Parking.CarPark;
import Parking.ParkingSlot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotBuilder {
    List<ParkingFloor> parkingFloorList;

    public ParkingLotBuilder() {
        this.parkingFloorList = new ArrayList<>();
    }

    public ParkingLotBuilder addParkingFloor(ParkingFloor parkingFloor) {
        parkingFloorList.add(parkingFloor);
        return this;
    }

    public ParkingLotBuilder createParkingFloor(int floorNumber, int numberSpots, int numCarSpots, int numBikesSpots) {
        ParkingFloor parkingFloor = new ParkingFloor(floorNumber);

        for(int i=0; i<numCarSpots; i++) {
            parkingFloor.addParkingSlot(new CarPark(i + 1, "Car"));
        }

        for(int i=0; i<numBikesSpots; i++) {
            parkingFloor.addParkingSlot(new BikePark(i + 1, "Bike"));
        }

        parkingFloorList.add(parkingFloor);

        return this;
    }
}

