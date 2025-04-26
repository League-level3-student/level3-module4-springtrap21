package _04_Maze_Maker;
import java.awt.Graphics;

public class Maze {
    // 1. Create a 2D array of cells. Don't initialize it.
    
    private int rows;
    private int cols;
    Cell[][] cellArray;

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        // 2. Initialize the cells array using the rows and cols variables
        cellArray = new Cell[rows][cols];
        // 3. Iterate through each cell and initialize it
        //    using row and col as the cell location
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cellArray[row][col] = new Cell(row, col);
            }
        }

    }

    // 4. This method iterates through the cells and draws them
    public void draw(Graphics g) {
    	for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				cellArray[row][col].draw(g);
			}
		}
    }

    // 5. This method returns the selected cell
    public Cell getCell(int row, int col){
        return  cellArray[row][col];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
