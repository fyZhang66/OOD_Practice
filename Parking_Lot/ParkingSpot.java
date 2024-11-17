package Parking_Lot;
public class ParkingSpot {
    private VehicleSize size;
    private Vehicle vehicle;
    private int row;
    private int spotNumber;
    private Level level;

    public ParkingSpot(Level lvl, int r, int n, VehicleSize s){
        level = lvl;
        row = r;
        spotNumber = n;
        size = s;
    }

    public boolean isAvailable(){
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle vehicle){
        return isAvailable() && vehicle.canFitInSpot(this);
    }

    public boolean park(Vehicle v){
        if(!canFitVehicle(v)) return false;
        vehicle = v;
        vehicle.parkin(this);
        return true;
    }

    public boolean removeVehicle(){
        level.addOneAvailable();
        // parkout for clear all spots taken by a vehicle
        // this function use for clearing one spot only
        // vehicle.parkout();
        vehicle = null;
        return true;
    }

    public int getRow() {
        return row;
    }
    
    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleSize getSize() {
        return size;
    }
}
