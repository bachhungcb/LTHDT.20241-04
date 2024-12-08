package model;
import gem.Gem;
import java.util.List;
public abstract class Cell {
    private List<Gem> gems;
    private int position;
    private boolean isUpperRow;

    public List<Gem> getGems() {
        return gems;
    }

    public int getPosition() {
        return position;
    }

    public boolean isUpperRow() {
        return isUpperRow;
    }


}