package Parking_Lot;

public class Motocycle extends Vehicle {
    public Motocycle() {
        spotsNeeded = 1;
        size = VehicleSize.Motocycle;
    }
    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return true;
    }
}
