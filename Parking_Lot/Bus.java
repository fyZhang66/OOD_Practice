package Parking_Lot;

public class Bus extends Vehicle{
    public Bus() {
        spotsNeeded = 5;
        size = VehicleSize.Large;
    }

    // check spot type only
    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large;
    }
    
}
