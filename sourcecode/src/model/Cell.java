package model;
import gem.Gem;
import java.util.List;
public abstract class Cell {
    private List<Gem> gems;
    private int position;
    private boolean isUpperRow;
    //constructor
    public Cell() {
       //TODO: implement Cell constructor
    }

    public abstract void addGem(Gem gem);
    //getter
    public List<Gem> getGems() {
        return gems;
    }

    public int getPosition() {
        return position;
    }

    public boolean isUpperRow() {
        return isUpperRow;
    }
    //setter
    public void setGems(List<Gem> gems) {
        this.gems = gems;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setUpperRow(boolean upperRow) {
        isUpperRow = upperRow;
    }

    public abstract void removeGem(Gem gem);

    public abstract int getGemsCount();

    public abstract boolean isEmpty();

    public static boolean isGameOver(){
        //TODO: check 2 HalfCircle isEmpty()
        /*
        List<Cell> cells = getCellsFromGameboard(); // Replace with actual method to retrieve cells

    // Ensure there are exactly two HalfCircle cells
    int halfCircleCount = 0;
    for (Cell cell : cells) {
        if (cell instanceof HalfCircle) {
            halfCircleCount++;
            if (!cell.isEmpty()) {
                return false; // Game is not over if any HalfCircle is not empty
            }
        }
    }

    // Game over if exactly two HalfCircle cells are found and both are empty
    if (halfCircleCount == 2) {
        Player winner = determineWinner(); // Replace with actual winner determination logic
        System.out.println("Game Over! Winner: " + winner);
        return true;
    }
         */
        return false;
    }

}