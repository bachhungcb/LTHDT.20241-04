package model;

import gems.Gems;

public class halfCircle extends Cell {

	public halfCircle(int position, boolean isUpperRow, int numberOfGems) {
		super(position, isUpperRow, numberOfGems);
	}

	// Phương thức thêm sỏi vào bán cầu
	public void addGem(Gems gem) {
		getGems().add(gem);
	}

	// Phương thức xóa sỏi khỏi bán cầu
	public void removeGem(Gems gem) {
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
		for (Gems gem : getGems()) {
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
