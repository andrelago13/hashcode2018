import java.io.*;
import java.util.ArrayList;

public class OutputWritter {

    public static void main(String[] args) throws IOException {
        ArrayList<Result> results = new ArrayList<>();
        ArrayList<Integer> numbers1 = new ArrayList<>();
        ArrayList<Integer> numbers2 = new ArrayList<>();
        ArrayList<Integer> numbers3 = new ArrayList<>();

        numbers1.add(2);
        numbers2.add(4);
        numbers2.add(5);
        numbers3.add(2);

        results.add(new Result(1,numbers1));
        results.add(new Result(2,numbers2));
        results.add(new Result(3,numbers3));


        writeFile(results);
    }

    public static void writeFile(ArrayList<Result> res) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("foo.out")));
        for(Result result : res){
            out.println(result.getnRides()+" " + result.convertRides());
        }
        out.close();
    }

}
