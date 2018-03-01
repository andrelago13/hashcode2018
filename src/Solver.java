import java.util.Comparator;

public class Solver {
    public static Object solve(Object input) {
        return null;
    }

    public static Object solveNaive() {

        Utils.rides.sort(new Comparator<Ride>() {
            @Override
            public int compare(Ride o1, Ride o2) {
                if(o1.beginDate < o2.beginDate) {
                    return -1;
                } else if (o1.beginDate > o2.beginDate) {
                    return 1;
                }
                if(o1.endDate < o2.endDate) {
                    return -1;
                } else if (o1.endDate > o2.endDate) {
                    return 1;
                }
                return 0;
            }
        });

        for(Vehicle v : Utils.vehicles) {
            int bestRideScore = 0;
            Ride bestRide = null;

            for(Ride r : Utils.rides) {

                if(!isRidePossible(v, r)) {
                    continue;
                }

                int rideScore = rideScore(v, r);

                if(rideScore > bestRideScore) {
                    bestRide = r;
                    bestRideScore = rideScore;
                }
            }

            if(bestRide != null) {
                incVehicleAvailable(v, bestRide);
                v.rides.add(bestRide);
                bestRide.isBooked = true;
            }
        }

        return null;
    }

    public static boolean isRidePossible(Vehicle v, Ride r) {


        return false;
    }

    public static int rideScore(Vehicle v, Ride r) {
        return 0;
    }

    public static void incVehicleAvailable(Vehicle v, Ride r) {

    }
}
