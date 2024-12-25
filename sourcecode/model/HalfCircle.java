package model;



import gem.Gem;


public class HalfCircle extends Cell {

	public HalfCircle(int position, boolean isUpperRow, int numberOfGems) {
		super(position, isUpperRow, numberOfGems);
	}


	@Override
	public String toString() {
		return "HalfCircle {" + "position=" + getPosition() +
				", isUpperRow=" + isUpperRow() +
				", gemsCount=" + getGemsCount() +
				", score=" + calculateScore() + "}";
	}

}
