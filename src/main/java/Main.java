
import java.util.ArrayList;


import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Boolean> cells = new ArrayList<>(Collections.nCopies(9, false));
        cells.set(3, true);
        cells.set(4, true);
        cells.set(5, true);

        System.out.println("INITIAL DESERT:");
        cells.forEach(x -> System.out.println(x));
        System.out.println("----------------------");
        Desert desert = new Desert(cells);
        System.out.println(desert.toString());

        cells = new ArrayList<>(Collections.nCopies(16, false));
        cells.set(0, true);
        cells.set(4, true);
        cells.set(5, true);
        cells.set(6, true);
        cells.set(7, true);
        cells.set(11, true);

        System.out.println("INITIAL DESERT:");
        cells.forEach(x -> System.out.println(x));
        System.out.println("----------------------");
        desert = new Desert(cells);
        System.out.println(desert.toString());
    }
}
