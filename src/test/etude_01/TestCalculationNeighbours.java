package etude_01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCalculationNeighbours {

    private Desert desert7x7;
    private static final Logger LOGGER = LogManager.getLogger(TestCalculationNeighbours.class);

    @Test
    public void testCalculateNeighbours(){
        desert7x7 = new Desert(7);
        LOGGER.info("Empty DESERT:");
        LOGGER.info(desert7x7.toString());
        desert7x7.setGerms(1, 15, 22, 23, 24, 25, 26, 32, 33);
        LOGGER.info("INITIAL DESERT:");
        LOGGER.info(desert7x7.toString());
        LOGGER.info("----------------------");

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
        LOGGER.info("Empty DESERT:");
        LOGGER.info(desert7x7.toString());
        desert7x7.setGerms(22, 23, 24, 25, 26);

        List<Desert> listOfExpectedGenerationalChanges = createListOfExpectedGenerationalChanges();
        System.out.println( listOfExpectedGenerationalChanges.get(0).toString());
        System.out.println( listOfExpectedGenerationalChanges.get(1).toString());
        System.out.println( listOfExpectedGenerationalChanges.get(2).toString());
        System.out.println( listOfExpectedGenerationalChanges.get(3).toString());
        System.out.println( listOfExpectedGenerationalChanges.get(4).toString());

        for (int i = 1 ; i < 9; i++) {
            printNextGen(desert7x7, String.valueOf(i));

            desert7x7.generationalChange();
        }
    }

    private void printNextGen(Desert desert, String generationName){
        LOGGER.info("GENERATION " + generationName + ":");
        LOGGER.info(desert7x7.toString());
    }

    private List<Desert> createListOfExpectedGenerationalChanges(){
        List<Desert> result = new ArrayList<>();
        Desert desert = new Desert(7);

        //The first generational change
        desert.setGerms(22,23,24,25,26);
        result.add(desert);

        //The second generational change
        desert = new Desert(7);
        desert.setGerms(16,17,18,23,24,25,30,31,32);
        result.add(desert);

        //The third  generational change
        desert = new Desert(7);
        desert.setGerms(10,16,18,22,26,30,32,38);
        result.add(desert);

        //The fourth  generational change
        desert = new Desert(7);
        desert.setGerms(10,16,17,18,22,23,25,26,30,31,32,38);
        result.add(desert);


        //The fifth  generational change
        desert = new Desert(7);
        desert.setGerms(9,10,11,15,19,22,26,29,33,37,38,39);
        result.add(desert);
        return result;
    }
}