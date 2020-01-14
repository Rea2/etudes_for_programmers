package eture_01;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;


public class Desert {
    private final static String GERM = " 0 ";
    private final static String EMPTINESS = " * ";
    private List<Boolean> cells;
    private int dimension;

    public Desert(int dimension) {
       this.dimension = dimension;
        cells =   new ArrayList<>(Collections.nCopies(dimension * dimension, false));
    }

    public Desert(List<Boolean> cells) {
        this.dimension =(int) Math.sqrt(cells.size());
        this.cells = cells;
        validateDesert();
    }

    public   void setGerms(  int ... cellIndexes) {
        for (int cell: cellIndexes) {
           cells.set(cell,true);
        }
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public void generationalChange(){

        //Create empty desert, with next generation
        List<Boolean> cellsNextGen =   new ArrayList<>(Collections.nCopies(dimension * dimension, false));
        for (int i = 0; i < cells.size(); i++) {
            int numberNeighbours  =  calculateNumberOfCellNeighbours(i);
            boolean currentCell  = cells.get(i);

            //A new germ will appears, if cell has 3 germs next door
            if (currentCell == false) {
                if (isCellMustBorn(numberNeighbours)) {
                    cellsNextGen.set(i, true);

                }
            //The existing germ, if cell it  has 2< or >3 neighbours
            } else {
                if(numberNeighbours < 2 || numberNeighbours > 3 ){
                    cellsNextGen.set(i,false);
                    System.out.println("Cell " + i + " is dead");
                } else {
                    cellsNextGen.set(i,true);
                }
            }
            }
        cells = cellsNextGen;
    }

    public int calculateNumberOfCellNeighbours(int indexOfCell) {
        // Counter of neighbours;
        int counter = 0;

        //  count left neighbours, if they exist
        if (isCellHaveLeftNeighbours(indexOfCell)) {
            counter = incrementNumberOfNeighbours(counter, indexOfCell + dimension - 1);
            counter = incrementNumberOfNeighbours(counter, indexOfCell - 1);
            counter = incrementNumberOfNeighbours(counter, indexOfCell - dimension - 1);
        }

        //  count left neighbours, if they exist
        if (isCellHaveRightNeighbours(indexOfCell)) {
            counter = incrementNumberOfNeighbours(counter, indexOfCell + dimension + 1);
            counter = incrementNumberOfNeighbours(counter, indexOfCell + 1);
            counter = incrementNumberOfNeighbours(counter, indexOfCell - dimension + 1);
        }

        //  count upper and down  neighbours, if they exist

            counter = incrementNumberOfNeighbours(counter, indexOfCell + dimension);
            counter = incrementNumberOfNeighbours(counter, indexOfCell - dimension);
        return counter;
    }

    private boolean isCellHaveLeftNeighbours(int x) {
        int rowNumber = x % dimension;
        if ( rowNumber == 0 ) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isCellHaveRightNeighbours(int x) {
        int rowNumber = x % dimension;
        if ( rowNumber == dimension - 1 ) {
            return false;
        } else {
            return true;
        }
    }

    private int incrementNumberOfNeighbours(int counter, int cellIndex) {
       if (isCellIntoListRange(cellIndex)) {
           if(cells.get(cellIndex) == true) {
                counter++;
           }
       }
       return counter;
    }

    private boolean isCellIntoListRange(int indexOfCell) {
        return indexOfCell < cells.size() && indexOfCell >=0;
    }

    private boolean isCellMustBorn(int numberOfNeighbours) {
       return numberOfNeighbours == 3;
    }


    private void validateDesert() {
        if (isDesertNotValid()) {
            throw new  IllegalStateException("eture_01.Desert is not valid: cells= " + cells.size() + "dimension = " + dimension);
        }
    }

    private boolean isDesertNotValid() {
        return cells.size() % dimension != 0;
    }

    @Override
    public String toString() {
        validateDesert();
        StringBuilder sb = new StringBuilder();
        try {
            for  (int i = 0; i < dimension; i++) {
                for  (int j = 0; j < dimension; j++) {
                     sb.append( cells.get(i * dimension + j) == true ? GERM : EMPTINESS );
                }
                sb.append("\n");
            }
        } catch (Exception e) {

        }

        return sb.toString();
    }
}