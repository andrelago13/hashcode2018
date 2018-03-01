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
        int[] lastCarPos = lastCarPos(v);
        int prepareDistance = Distance.getDistance(lastCarPos, r.beginLocal);
        int rideDistance = Distance.getDistance(r.beginLocal, r.endLocal);
        int totalDistance = prepareDistance + rideDistance;

        if(v.lastAvailable + totalDistance > r.endDate || v.lastAvailable + totalDistance > Utils.steps) {
            return false;
        }

        return true;
    }

    public static int rideScore(Vehicle v, Ride r) {
        return 0;
    }

    public static void incVehicleAvailable(Vehicle v, Ride r) {

    }

    public static int[] lastCarPos(Vehicle v) {
        int[] lastCarPos = new int[] {0, 0};
        if(v.rides.size() > 0) {
            Ride lastRide = v.rides.get(v.rides.size() - 1);
            lastCarPos[0] = lastRide.endLocal[0];
            lastCarPos[1] = lastRide.endLocal[1];
        }
        return lastCarPos;
    }
}
