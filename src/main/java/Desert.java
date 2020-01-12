import java.util.ArrayList;

import java.util.Collections;
import java.util.List;


public class Desert {
    private final static char GERM = 'O';
    private final static char EMPTINESS = '*';
    private List<Boolean> cells;
    private int dimension;

    public Desert(int dimension) {
       this.dimension = dimension;
        cells = new ArrayList<>(dimension * dimension);
    }

    public Desert(List<Boolean> cells) {
        this.dimension =(int) Math.sqrt(cells.size());
        this.cells = cells;
        validateDesert();
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public void generationalChange(){

        //Create empty desert, where new state will be stored
        List<Boolean> cellsNextGen =   new ArrayList<>(Collections.nCopies(dimension * dimension, false));
        for (int i = 0; i<cells.size(); i++) {
            int numberNeighbours  =  calculateNumberOfCellNeighbours(i);
            if (isCellLive(numberNeighbours)) {
                cellsNextGen.set(i,true);
            } else {
                cellsNextGen.set(i,false);
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
        if (isCellHaveRightNeighbours(indexOfCell)) {
            counter = incrementNumberOfNeighbours(counter, indexOfCell + dimension + 1);
            counter = incrementNumberOfNeighbours(counter, indexOfCell + 1);
            counter = incrementNumberOfNeighbours(counter, indexOfCell - dimension + 1);
        }
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
           return ++counter;
       } else {
           return counter;
       }
    }

    private boolean isCellIntoListRange(int indexOfCell) {
        return indexOfCell < cells.size() && indexOfCell >=0;
    }

    private boolean isCellLive(int numberOfNeighbours) {
       return numberOfNeighbours == 2 || numberOfNeighbours ==3;
    }


    private void validateDesert() {
        if (isDesertNotValid()) {
            throw new  IllegalStateException("Desert is not valid: cells= " + cells.size() + "dimension = " + dimension);
        }
    }

    private boolean isDesertNotValid() {
        return cells.size() % dimension != 0;
    }

    @Override
    public String toString() {
       validateDesert();
        StringBuilder sb = new StringBuilder();
        for  (int i = 0; i < dimension; i++) {
            for  (int j = 0; j < dimension; j++) {
                 sb.append( cells.get(i * dimension + j) == true ? GERM : EMPTINESS );
            }
            sb.append("\n");
        }

        return sb.reverse().toString();
    }
}
