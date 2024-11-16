package Parking_Lot;

import java.util.ArrayList;

public abstract class Vehicle {
    protected String licensePlate;
    protected VehicleSize size;
    protected int spotsNeeded;
    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();

    public String getLicensePlate() {
        return licensePlate;
    }

    // get Vehicle size
    public VehicleSize getSize() {
        return size;
    }

    // get spots needed by vehicle
    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    // remove all spots taken by the vehicle
    public void parkout() {
        for (int i = 0; i < parkingSpots.size(); i++) {
            parkingSpots.get(i).removeVehicle();
        }
        parkingSpots.clear();
    }

    // add spot to taken list
    public void parkin(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    public abstract boolean canFitInSpot(ParkingSpot spot);
}
