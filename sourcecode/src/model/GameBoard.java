package model;

import gem.BigGem;
import gem.SmallGem;

import java.util.List;

public class GameBoard {
    private static final int numSquare = 10;
    private final int numHalfCircle = 2;  // even number
    private final int numSmallGem = 50;
    private final int numBigGem = 2;
    private Cell[] cells = new Cell[numHalfCircle + numSquare];

    // Constructor
    public GameBoard(){

        this.cells[0] = new HalfCircle(0, false, 0);
        this.cells[0].addGem(new BigGem(this.cells[0]));
        this.cells[0].addGem(new SmallGem(this.cells[0]));

        this.cells[6] = new HalfCircle(6, true, 0);;
        this.cells[6].addGem(new BigGem(this.cells[11]));
        this.cells[6].addGem(new SmallGem(this.cells[11]));
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
    public static int getNumSquare(){return numSquare;}
    public int getNumSmallGem(){return numSmallGem;}
    public int getNumHalfCircle(){return numHalfCircle;}
    public int getNumBigGem(){return numBigGem;}

    // Setter
    public void setCells(List<Cell> cells) {
        this.cells = cells.toArray(new Cell[0]);
    }

    // Get the score of a player
    public int getScore(Player player) {
        return player.getScore();
    }

    // Get the name of a player
    public String getPlayerName(Player player) {
        return player.getName();
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
    // Display the game menu
    public void showMenu() {
        // TODO: Implement the menu display logic
        System.out.println("1. Start Game");
        System.out.println("2. View Scores");
        System.out.println("3. Exit");
    }
}
