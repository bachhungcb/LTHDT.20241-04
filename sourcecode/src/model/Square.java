package model;

import model.Cell;
import java.util.List;

import gems.Gems;

import java.util.ArrayList;

public class Square {

    private int position;
   private List<Gems> gems;

    // public Square(int position) {
    //     this.position = position;
    //     this.gems = new ArrayList<>();
    // }

    // public void addGem(Gems gem) {  
        
    // }

    public void removeGem() {
    
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

    