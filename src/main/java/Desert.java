import java.util.ArrayList;
import java.util.Arrays;
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
        List<Boolean> cellsUpdated =   new ArrayList<>(Collections.nCopies(dimension * dimension, false));
        for (int i = 0; i<cells.size(); i++) {
            boolean cell =  calculateCellForGenerationalChange(i);
            cellsUpdated.set(i, cell);
        }
    }

    public boolean calculateCellForGenerationalChange(int indexOfCell){
        int result = 0;
        int[] allCellsNeighbours = {
                indexOfCell + dimension -1, indexOfCell + dimension, indexOfCell + dimension +1,
                indexOfCell - 1, indexOfCell + 1,
                indexOfCell - dimension -1, indexOfCell - dimension, indexOfCell + dimension +1,
        };

        int[] existingCellNeighbours = Arrays.stream(allCellsNeighbours).filter( x -> x < cells.size() && x >=0 ).toArray();
        return  false;
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
