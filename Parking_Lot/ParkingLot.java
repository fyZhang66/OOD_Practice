package Parking_Lot;

public class ParkingLot {
    private Level[] levels;
    private final int NUM_LEVELS = 5;

    public ParkingLot(){
        levels = new Level[NUM_LEVELS];
        for(int i = 0; i < NUM_LEVELS; i++){
            levels[i] = new Level(i, 30);
        }
    }

    public boolean parkVehicle(Vehicle v){
        // iterate every level until find a suitable level
        // dont need to check every level manually
        for(int i = 0; i < levels.length; i++){
            if(levels[i].parkVehicle(v)){
                return true;
            }
        }
        return false;
    }
    
}
