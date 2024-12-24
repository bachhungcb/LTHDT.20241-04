package model;

import gem.BigGem;
import gem.SmallGem;

public class GameBoard {
    private static final int numSquare = 10;
    private final int numHalfCircle = 2;  // even number
    private Cell[] cells = new Cell[numHalfCircle + numSquare];

    // Constructor
    public GameBoard(){

        this.cells[0] = new HalfCircle(0, false, 0);
        this.cells[0].addGem(new BigGem(this.cells[0]));

        this.cells[6] = new HalfCircle(6, true, 0);;
        this.cells[6].addGem(new BigGem(this.cells[11]));
        for(int i = 1; i <= 5; i++) {
            this.cells[i] = new Square(i, false,0);
            for(int j = 0; j < 5; j++) {
                this.cells[i].addGem(new SmallGem(this.cells[i]));
            }
        }
        for(int i = 7; i <= 11; i++) {
            this.cells[i] = new Square(i, true,0);
            for(int j = 0; j < 5; j++) {
                this.cells[i].addGem(new SmallGem(this.cells[i]));
            }
        }
    }

    // Getter
    public Cell[] getCells() {
        return cells;
    }


    public Cell[] getBoard(){
        return cells;
    }

    public Cell getNextCellCounterClockwise(Cell cell){
        if(cell.getPosition() == 0) {
            return this.cells[numSquare + numHalfCircle - 1];
        }
        else {
            return this.cells[cell.getPosition() - 1];
        }
    }

    public Cell getNextCellClockwise(Cell cell) {
        if(cell.getPosition() == numSquare + numHalfCircle - 1) {
            return this.cells[0];
        }
        else {
            return this.cells[cell.getPosition() + 1];
        }
    }
}
