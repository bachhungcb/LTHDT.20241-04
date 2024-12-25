package model;

import gem.Gem;

public class Square extends Cell implements Pickable{

    public Square(int position, boolean isUpperRow, int numberOfGems) {
        super(position, isUpperRow, numberOfGems);
    }

    @Override
    public boolean isPickable() {
        return true;
    }
    //method toString() trong Square
    @Override
    public String toString() {
        return "Square{" +
                "position=" + getPosition() +
                ", isUpperRow=" + isUpperRow() +
                ", gemsCount=" + getGemsCount() +
                ", score=" + calculateScore() +
                '}';
    }

}
