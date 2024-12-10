package model;

import gem.BigGem;
import gem.Gem;
import gem.SmallGem;

public class test {
	public static void main(String[] args) {
		Square square1 = new Square(1);
		Square square2 = new Square(2);

		// Tạo các đối tượng Gem
		Gem bigGem = new BigGem(square1);
		Gem smallGem = new SmallGem(square2);

		// Thêm sỏi vào ô
		square1.addGem(bigGem);
		square2.addGem(smallGem);

		// Hiển thị số lượng sỏi trong mỗi ô
		System.out.println("Số lượng sỏi trong ô 1: " + square1.getGemsCount());
		System.out.println("Số lượng sỏi trong ô 2: " + square2.getGemsCount());

		// Kiểm tra nếu ô có thể nhặt sỏi
		System.out.println("Ô 1 có thể nhặt không? " + square1.isPickable());

		// Xóa một viên sỏi
		square1.removeGem(bigGem);
		System.out.println("Số lượng sỏi trong ô 1 sau khi xóa: " + square1.getGemsCount());
	}

}
