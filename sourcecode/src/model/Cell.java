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

    public boolean isGameOver(){
        //TODO: check 2 HalfCircle isEmpty()
        return false;
    }

}