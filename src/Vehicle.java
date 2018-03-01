import java.util.ArrayList;

public class Vehicle {
    public int lastAvailable = 0;

    public ArrayList<Ride> getRides() {
        return rides;
    }

    public void setRides(ArrayList<Ride> rides) {
        this.rides = rides;
    }

    ArrayList<Ride> rides = new ArrayList<>();
}
