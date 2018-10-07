package com.paulbesret.gameoflife;

public class GridManager {

    private static int rows;
    private static int columns;
    private static Cell[][] grid;

    public static int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        GridManager.rows = rows;
    }

    public static int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        GridManager.columns = columns;
    }

    // Initialize a grid of cells
    public Cell[][] initialize(){
        Cell[][] grid = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++){
                grid[i][j] = new Cell(i,j);
            }
        }
        return grid;
    }

    // Duplicate a grid
    public Cell[][] duplicate(Cell[][] grid){
        Cell[][] duplicatedGrid = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++){
                duplicatedGrid[i][j] = new Cell(i,j);
                duplicatedGrid[i][j].setType(grid[i][j].getType());
            }
        }
        return duplicatedGrid;
    }

    // Print the content of a grid
    public void print(Cell[][] grid){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++){
                System.out.print(grid[i][j].getType() == CellType.Populated ? "O" : "X");
            }
            System.out.println();
        }
    }

    // Setup content of a given cell
    public void setCellContent(Cell[][] grid, int x, int y, CellType type){
        grid[x][y].setType(type);
    }
}
