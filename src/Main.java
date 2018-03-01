import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        runB();
    }

    public static void runA() throws IOException {
        Utils utils = new Utils();
        utils.parse("res/a_example.in");
        Solver.solveNaive();
        OutputWritter.writeFile(Solver.parseSolution(),"a.out");
    }
    public static void runB() throws IOException {
        Utils utils = new Utils();
        utils.parse("res/b_should_be_easy.in");
        Solver.solveRecursive();
        OutputWritter.writeFile(Solver.parseSolution(),"b.out");
    }
    public static void runC() throws IOException {
        Utils utils = new Utils();
        utils.parse("res/c_no_hurry.in");
        Solver.solveNaive();
        OutputWritter.writeFile(Solver.parseSolution(),"c.out");
    }
    public static void runD() throws IOException {
        Utils utils = new Utils();
        utils.parse("res/d_metropolis.in");
        Solver.solveNaive();
        OutputWritter.writeFile(Solver.parseSolution(),"d.out");
    }
    public static void runE() throws IOException {
        Utils utils = new Utils();
        utils.parse("res/e_high_bonus.in");
        Solver.solveNaive();
        OutputWritter.writeFile(Solver.parseSolution(),"e.out");
    }
}
