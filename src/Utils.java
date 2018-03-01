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

                specification(specification);
                fillRides(content);
                //System.out.println("Specification: \n" + specification);
                //System.out.println("Content: \n" + content);

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

        String vars[] = spec.split(" ");
        map.add(Integer.parseInt(vars[0]));
        map.add(Integer.parseInt(vars[1]));

        for(int i=0; i<Integer.parseInt(vars[2]);++i){
            Vehicle v = new Vehicle();
            vehicles.add(v);
        }

        for(int j=0; j<Integer.parseInt(vars[3]);++j){
            Ride r = new Ride();
            rides.add(r);

        }

        bonus = Integer.parseInt(vars[4]);

        steps = Integer.parseInt(vars[5]);

    }

    public void fillRides(String content){
        String lines[] = content.split("\n");
        for(int i=0;i<rides.size();++i){
            String vars[] = lines[i].split(" ");

            System.out.println("Populating Ride...");
            Integer origin[] = new Integer[2];
            Integer destination[] = new Integer[2];
            origin[0] = Integer.parseInt(vars[0]);
            origin[1] = Integer.parseInt(vars[1]);
            destination[0] = Integer.parseInt(vars[2]);
            destination[1] = Integer.parseInt(vars[3]);
            rides.get(i).setBeginLocal(origin);
            rides.get(i).setEndLocal(destination);
            rides.get(i).setBeginDate(Integer.parseInt(vars[4]));
            rides.get(i).index = i;

            //String endDate = "";
            //for(int j=0;j<(vars[5]).length()-1;++j)
            //    endDate+=(vars[5]).charAt(j);

            rides.get(i).setEndDate(Integer.parseInt(vars[5]));
        }
    }

    public static void storeResult(Object result) {

    }
}
