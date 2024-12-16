package model;

import gem.Gem;

public class Square extends Cell implements Pickable{

    public Square(int position, boolean isUpperRow, int numberOfGems) {
        super(position, isUpperRow, numberOfGems);
    }

    // Phương thức thêm sỏi vào bán cầu
    public void addGem(Gem gem) {
        gems.add(gem);
    }
    
    //Phương thức xóa 1 viên sỏi khỏi ô vuông nếu có
	public void removeGem(Gem gem) {
		gems.remove(gem);
	}

    public int getGemsCount() {
        return getNUmberOfGems();
    }

    public boolean isEmpty() {
        return gems.isEmpty();
    }

    public boolean isPickable() {
        return true;
    }
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
