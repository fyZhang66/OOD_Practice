package Parking_Lot;

public class Car extends Vehicle {

    public Car() {
        spotsNeeded = 1;
        size = VehicleSize.Compact;
    }
    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        // only large and compact can fit in car
        return spot.getSize() == VehicleSize.Compact || spot.getSize() == VehicleSize.Large;
    }
}
