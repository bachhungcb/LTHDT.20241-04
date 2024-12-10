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

    // Phương thức thêm sỏi vào bán cầu
    public void addGem(Gem gem) {
        gems.add(gem);
    }

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

    public static void main(String[] args) {
    	Square square = new Square(1);
        Gem gem1 = new Gem();
        Gem gem2 = new Gem();
        square.addGem(gem1);
        square.addGem(gem2);
        System.out.println("Add 2 gems to square 1");
    }

}
