import java.util.Comparator;

public class Solver {
    public static final Comparator<Ride> rideComparator = new Comparator<Ride>() {
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
    };

    public static Object solve(Object input) {
        return null;
    }

    public static Object solveNaive() {
        Utils.rides.sort(rideComparator);

        for(Vehicle v : Utils.vehicles) {
            Ride bestRide = getBestRide(v);

            if(bestRide != null) {
                incVehicleAvailable(v, bestRide);
                v.rides.add(bestRide);
                bestRide.isBooked = true;
            }

        }

        return null;
    }

    public static void solveRecursive() {
        Utils.rides.sort(rideComparator);

        for(Vehicle v : Utils.vehicles) {
            int score = getVehicleScore(v);
        }
    }

    public static int getVehicleScore(Vehicle v) {
        Ride r = getFirstPossibleRide(v);

        if(r == null) {
            return calculateVehicleScore(v);
        }

        r.isBooked = true;

        int scoreWithoutRide = getVehicleScore(v);

        v.rides.add(r);
        int vehicleAvailableBeforeRide = v.lastAvailable;
        incVehicleAvailable(v, r);

        int scoreWithRide = getVehicleScore(v);

        if(scoreWithRide > scoreWithoutRide) {
            return scoreWithRide;
        } else {
            v.rides.remove(r);
            v.lastAvailable = vehicleAvailableBeforeRide;
            return scoreWithoutRide;
        }
    }

    public static Ride getFirstPossibleRide(Vehicle v) {
        for(Ride r : Utils.rides){
            if(isRidePossible(v,r)){
                return r;
            }
        }
        return null;
    }

    public static int calculateVehicleScore(Vehicle v) {
        Integer[] pos = new Integer[] {0, 0};
        int vehicleScore = 0;
        int availableBackup = v.lastAvailable;
        v.lastAvailable = 0;

        for(Ride r : v.rides) {
            vehicleScore += rideScore(v, r);
            incVehicleAvailable(v, r, pos);
            pos = r.endLocal;
        }

        v.lastAvailable = availableBackup;
        return vehicleScore;
    }

    public static Ride getBestRide(Vehicle v) {
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

        return bestRide;
    }

    public static boolean isRidePossible(Vehicle v, Ride r) {
        Integer[] lastCarPos = lastCarPos(v);
        if(r.isBooked) {
            return false;
        }

        int prepareDistance = Distance.getDistance(lastCarPos, r.beginLocal);
        int rideDistance = Distance.getDistance(r.beginLocal, r.endLocal);
        int totalDistance = prepareDistance + rideDistance;

        if(v.lastAvailable + totalDistance > r.endDate || v.lastAvailable + totalDistance > Utils.steps) {
            return false;
        }

        return true;
    }

    public static int rideScore(Vehicle v, Ride r) {
        int score = 0;
        score += Distance.getDistance(r.beginLocal,r.endLocal);
        Integer[] lastRide = lastCarPos(v);
        if(Distance.getDistance(lastRide,r.getBeginLocal()) + v.lastAvailable <= r.getBeginDate())
            score+=Utils.bonus;
        return score;
    }

    public static void incVehicleAvailable(Vehicle v, Ride r) {
        incVehicleAvailable(v, r, lastCarPos(v));
    }

    public static void incVehicleAvailable(Vehicle v, Ride r, Integer[] lastCarPos) {
        int prepareDistance = Distance.getDistance(lastCarPos, r.beginLocal);
        int rideDistance = Distance.getDistance(r.beginLocal, r.endLocal);
        int totalDistance = prepareDistance + rideDistance;

        if(v.lastAvailable + prepareDistance <= r.beginDate) {
            v.lastAvailable = r.beginDate + rideDistance;
        } else {
            v.lastAvailable = v.lastAvailable + totalDistance;
        }
    }

    public static Integer[] lastCarPos(Vehicle v) {
        Integer[] lastCarPos = new Integer[] {0, 0};
        if(v.rides.size() > 0) {
            Ride lastRide = v.rides.get(v.rides.size() - 1);
            lastCarPos[0] = lastRide.endLocal[0];
            lastCarPos[1] = lastRide.endLocal[1];
        }
        return lastCarPos;
    }
}
