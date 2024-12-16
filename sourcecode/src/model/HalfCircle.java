package model;

import java.util.List;

import gem.Gem;
import model.Cell;

public class HalfCircle extends Cell {

	public HalfCircle(int position, boolean isUpperRow, int numberOfGems) {
		super(position, isUpperRow, numberOfGems);
	}

	// Phương thức thêm sỏi vào bán cầu
	public void addGem(Gem gem) {
		getGems().add(gem);
	}
	
	//Phương thức xóa sỏi khỏi bán cầu
	// Phương thức xóa sỏi khỏi bán cầu
	public void removeGem(Gem gem) {
		getGems().remove(gem);
	}

	// Phương thức lấy số sỏi trong bán cầu
	public int getGemsCount() {
        return getGems().size();
	}

	// Phương thức kiểm tra bán cầu có rỗng không
	public boolean isEmpty() {
		return getGems().isEmpty();
	}

	// Phương thức tính điểm của bán cầu
	public int calculateScore() {
		int score = 0;
		for (Gem gem : getGems()) {
			score += gem.getValue();
		}
		return score;
	}

	@Override
	public String toString() {
		return "HalfCircle {" + "position=" + getPosition() +
				", isUpperRow=" + isUpperRow() +
				", gemsCount=" + getGemsCount() +
				", score=" + calculateScore() + "}";
	}

}
