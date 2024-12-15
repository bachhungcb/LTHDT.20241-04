package model;
import gem.Gem;
import java.util.ArrayList;
import java.util.List;
public abstract class Cell {
    protected List<Gem> gems;
    private int position;
    private boolean isUpperRow;
    private int score;
    
    //constructor
    public Cell(int position , boolean isUpperRow) {
       //TODO: implement Cell constructor
    	this.gems= new ArrayList<>();
    	this.position=position;
    	this.isUpperRow=isUpperRow;
    	
    }

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
    public int getScore() {
    	return score;
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
    public void setScore(int score) {
    	this.score = score;
    }
    //abtract method 
    public abstract void addGem(Gem gem);

    public abstract void removeGem(Gem gem);

    public abstract int getGemsCount();

    public abstract boolean isEmpty();
    
 // Method to check if it's a half-circle
    public boolean isHalfCircle() {
        if (this.isUpperRow()) {
            return position == 0;  // Giả sử ô half-circle trên ở vị trí 0
        } else {
            return position == 11;  // Giả sử ô half-circle dưới ở vị trí 11
        }
    }

 // Method to check if the game is over (both half-circles are empty)
    public static boolean isGameOver(List<Cell> cells) {
        boolean upperHalfCircleEmpty = true;
        boolean lowerHalfCircleEmpty = true;
        // Check the status of the half-circle cells
        for (Cell cell : cells) {
            if (cell.isHalfCircle()) {
                if (cell.isEmpty()) {
                    if (cell.isUpperRow()) {
                        upperHalfCircleEmpty = true;
                    } else {
                        lowerHalfCircleEmpty = true;
                    }
                } else {
                    if (cell.isUpperRow()) {
                        upperHalfCircleEmpty = false;
                    } else {
                        lowerHalfCircleEmpty = false;
                    }
                }
            }
        }

        // The game ends if both half-circle cells are empty
        return upperHalfCircleEmpty && lowerHalfCircleEmpty;

    }
}

    
    
    
    
    
    
    
    
    
    
    
    

    

