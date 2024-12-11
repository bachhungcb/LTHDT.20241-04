package model;

import gem.Gem;
import java.util.ArrayList;
import java.util.List;

public class Square {

    private int position;
    private List<Gem> gems;

    public Square(int position) {
        this.position = position;
        this.gems = new ArrayList<>();
    }

    public void addGem(Gem gem) {
        // TODO: 
    }

    public void removeGem() {
        // TODO: 
    }

    public int getGemsCount() {
            return position;
   
    }

    public boolean isEmpty() {
            return false;
        
    }

    public boolean isPickable() {

        return true;
    }
}

    