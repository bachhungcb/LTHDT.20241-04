package model;

import gems.Gems;
import java.util.ArrayList;
import java.util.List;

public class Square {

    private int position;
    private List<Gems> gems;

    public Square(int position) {
        this.position = position;
        this.gems = new ArrayList<>();
    }

    public void addGem(Gems gem) {  
        // TODO: aaaaaaaaaaa
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

    