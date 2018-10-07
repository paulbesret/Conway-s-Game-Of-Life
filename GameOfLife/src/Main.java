import com.paulbesret.gameoflife.Cell;
import com.paulbesret.gameoflife.CellType;
import com.paulbesret.gameoflife.GridManager;

public class Main {

    private static GridManager gridManager;
    private static Cell[][] grid;
    private static int numberOfGenerations = 0;

    public static void main(String[] args) {
        // Initialize grid
        gridManager = new GridManager();
        gridManager.setRows(10);
        gridManager.setColumns(10);
        grid = gridManager.initialize();

        // Setup initial living cells
        gridManager.setCellContent(grid,4,5, CellType.Populated);
        gridManager.setCellContent(grid,5,5, CellType.Populated);
        gridManager.setCellContent(grid,5,6, CellType.Populated);
        gridManager.setCellContent(grid,5,4, CellType.Populated);
        gridManager.setCellContent(grid,6,5, CellType.Populated);

        // Print initial grid
        gridManager.print(grid);

        // Run the game
        while(true){
            run();
            numberOfGenerations++;
            System.out.println(numberOfGenerations);
        }
    }

    private static void run(){
        Cell[][] tempGrid = gridManager.duplicate(grid);
        try {
            for (int i = 1; i < gridManager.getRows() - 1; i++) {
                for (int j = 1; j < gridManager.getColumns() - 1; j++){
                    int populatedNeighbors = grid[i][j].checkNeighbors(grid);
                    if(grid[i][j].getType() == CellType.Populated){
                        if(populatedNeighbors == 1 || populatedNeighbors == 0){
                            // die
                            tempGrid[i][j].setType(CellType.Unpopulated);
                        } else if (populatedNeighbors >= 4){
                            // die
                            tempGrid[i][j].setType(CellType.Unpopulated);
                        } else if (populatedNeighbors == 2 || populatedNeighbors == 3){
                            // Survive
                            tempGrid[i][j].setType(CellType.Populated);
                        }
                    } else {
                        if(populatedNeighbors == 3){
                             // born
                            tempGrid[i][j].setType(CellType.Populated);
                        }
                    }
                }
            }
            System.out.println();
            Thread.sleep(1000);
        } catch (InterruptedException e){
            System.err.println(e);
        }
        grid = tempGrid;
        gridManager.print(grid);
    }
}
