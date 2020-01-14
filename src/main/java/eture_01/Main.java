package eture_01;

public class Main {


    public static void main(String[] args) {
          new Main().test7x7();
        
//        cells.set(3, true);
//        cells.set(4, true);
//        cells.set(5, true);
//
//        System.out.println("INITIAL DESERT:");
//        cells.forEach(x -> System.out.println(x));
//        System.out.println("----------------------");
//        eture_01.Desert desert = new eture_01.Desert(cells);
//        System.out.println(desert.toString());
//
//        cells = new ArrayList<>(Collections.nCopies(16, false));
//        cells.set(0, true);
//        cells.set(4, true);
//        cells.set(5, true);
//        cells.set(6, true);
//        cells.set(7, true);
//        cells.set(11, true);
//
//        System.out.println("INITIAL DESERT:");
//        cells.forEach(x -> System.out.println(x));
//        System.out.println("----------------------");
//        desert = new eture_01.Desert(cells);
//        System.out.println(desert.toString());
    }


    public void test7x7() {
        Desert desert7x7 = new Desert(7);
        System.out.println("Empty DESERT:");
        System.out.println(desert7x7.toString());
        desert7x7.setGerms(22,23,24,25,26);
        System.out.println("INITIAL DESERT:");
        System.out.println(desert7x7.toString());
        System.out.println("----------------------");



        desert7x7.generationalChange();
        System.out.println("2 GENERATION:");
        System.out.println(desert7x7.toString());
        desert7x7.generationalChange();
        System.out.println("3 GENERATION");
        System.out.println(desert7x7.toString());

    }

    private void printNeighbors(){

    }

  


}
