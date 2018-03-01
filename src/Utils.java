import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Utils {

    public static ArrayList<Integer> map = new ArrayList<Integer>();
    public static ArrayList<Ride> rides = new ArrayList<Ride>();
    public static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    public static Integer bonus;
    public static Integer steps;

    public static void solve() {
        //Object input = parse();
        //Object result = Solver.solve(input);
        //storeResult(result);
    }

    public void parse(String filename) {

        String specification="";
        boolean first=true;

        try {
            System.out.println("Trying to read file: " + filename);
            BufferedReader buffer = new BufferedReader(new FileReader(filename));
            System.out.println("Reading file...");

            try {
                StringBuilder builder = new StringBuilder();
                String line = buffer.readLine();
                while (line != null) {
                    if(first){
                        specification += line;
                        first=false;
                        line=buffer.readLine();
                    }
                    else{
                        builder.append(line);
                        builder.append(System.lineSeparator());
                        line=buffer.readLine();
                    }
                }
                String content = builder.toString();

                System.out.println("Specification: \n" + specification);
                System.out.println("Content: \n" + content);

            } catch (IOException e) {
                System.out.println("Error reading file");
                e.printStackTrace();
            } finally {
                try {
                    buffer.close();
                } catch (IOException e) {
                    System.out.println("Error closing buffer");
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found" + filename);
            e.printStackTrace();
        }

    }

    public void specification(String spec){

    }

    public static void storeResult(Object result) {

    }
}
