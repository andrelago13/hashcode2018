import java.util.ArrayList;

public class Result {
    private int nRides;
    private ArrayList<Integer> rideNumbers;

    public Result(int nRides, ArrayList<Integer> rideNumbers) {
        this.nRides = nRides;
        this.rideNumbers = rideNumbers;
    }

    public int getnRides() {
        return nRides;
    }

    public ArrayList<Integer> getRideNumbers() {
        return rideNumbers;
    }

    public String convertRides(){
        String res = "";
        for(Integer i : rideNumbers){
            res+=i+" ";
        }
        return res;
    }
}
