package Parking_Lot;

public class Level {
    private int floor;
    private ParkingSpot[] spots;
    private int availableSpots = 0;
    private static final int SPOTS_PER_ROW = 10;

    public int getAvailableSpots() {
        return availableSpots;
    }

    public Level(int flr, int numberSpots) {
        floor = flr;
        spots = new ParkingSpot[numberSpots];
        int spotIdx = 0;
        for (int row = 0; row < numberSpots / SPOTS_PER_ROW; row++) {
            for (int spot = 0; spot < SPOTS_PER_ROW; spot++) {
                // each row has 3 motorcycle spots, 2 compact spots, and 5 large spots
                VehicleSize sz = (spot < SPOTS_PER_ROW / 4) ? VehicleSize.Motocycle
                        : (spot < SPOTS_PER_ROW / 2) ? VehicleSize.Compact : VehicleSize.Large;
                spots[spotIdx] = new ParkingSpot(this, row, spotIdx, sz);
                spotIdx++;
            }
        }
        availableSpots = numberSpots;
    }

    public int findAvailableSpots(Vehicle vehicle){
        int spotsNeeded = vehicle.getSpotsNeeded();
        int lastRow = -1;
        int spotsFound = 0;
        for(int i=0; i< spots.length; i++){
            ParkingSpot spot = spots[i];
            if(lastRow != spot.getRow()){
                spotsFound = 0;
                lastRow = spot.getRow();
            }
            if(spot.canFitVehicle(vehicle)){
                spotsFound++;
            }else{
                spotsFound = 0;
            }
            if(spotsFound == spotsNeeded){
                return i - (spotsNeeded - 1);
            }
        }
        return -1;
    }

    public boolean parkStartAtSpot(int spotIdx, Vehicle vehicle){
        for(int i = spotIdx; i < spotIdx + vehicle.getSpotsNeeded(); i++){
            // check if the spot is partially taken
            // although we've already checked the availability, we still need to check again
            // because the spot might be taken by another process (e.g., parallel parking attempt)
            if(!spots[i].park(vehicle)){
                // reset partial taken spots
                for(int j = spotIdx; j < i; j++){
                    spots[j].removeVehicle();
                }
                return false;
            }
        }
        availableSpots -= vehicle.getSpotsNeeded();
        return true;
    }

    public boolean parkVehicle(Vehicle v){
        int availableSpotIdx = findAvailableSpots(v);
        if(availableSpotIdx < 0){
            return false;
        }
        return parkStartAtSpot(availableSpotIdx, v);
    }

    public void addOneAvailable(){
        availableSpots++;
    }
}
