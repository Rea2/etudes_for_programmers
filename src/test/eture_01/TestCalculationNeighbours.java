package eture_01;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCalculationNeighbours {

    private Desert desert7x7;

    @Test
    public void testCalculateNeighbours(){
        desert7x7 = new Desert(7);
        System.out.println("Empty DESERT:");
        System.out.println(desert7x7.toString());
        desert7x7.setGerms(1, 15, 22, 23, 24, 25, 26, 32, 33);

        System.out.println("INITIAL DESERT:");
        System.out.println(desert7x7.toString());
        System.out.println("----------------------");

        assertAll("Should return address of Oracle's headquarter",
                () -> assertEquals(2, desert7x7.calculateNumberOfCellNeighbours(21), "Leftmost cell:" + 21 ),
                () -> assertEquals(1, desert7x7.calculateNumberOfCellNeighbours(20), "Rightmost cell:"+ 20 ),
                () -> assertEquals(4, desert7x7.calculateNumberOfCellNeighbours(25), "Middle cell:"+ 25 ),
                () -> assertEquals(1, desert7x7.calculateNumberOfCellNeighbours(0), "Left corner cell:"+ 0),
                () -> assertEquals(0, desert7x7.calculateNumberOfCellNeighbours(6), "Right corner cell:"+ 6)
        );
    }

    @Test
    public void testGenerationalChange() {
        desert7x7 = new Desert(7);
        System.out.println("Empty DESERT:");
        System.out.println(desert7x7.toString());
        desert7x7.setGerms(22, 23, 24, 25, 26);

        System.out.println("INITIAL DESERT:");
        System.out.println(desert7x7.toString());
        System.out.println("----------------------");
        desert7x7.generationalChange();
        System.out.println("2 GENERATION:");
        System.out.println(desert7x7.toString());
        desert7x7.generationalChange();
        System.out.println("3 GENERATION");
        System.out.println(desert7x7.toString());
        desert7x7.generationalChange();
        System.out.println("4 GENERATION");
        System.out.println(desert7x7.toString());
        desert7x7.generationalChange();
        System.out.println("6 GENERATION");
        System.out.println(desert7x7.toString());
    }



    private void printNeighbors(Desert desert,  int cellNumber){
        int numberOfNeighbours = desert.calculateNumberOfCellNeighbours(cellNumber);
        System.out.println("cell " + cellNumber + " has "  + numberOfNeighbours);
    }

  


}
