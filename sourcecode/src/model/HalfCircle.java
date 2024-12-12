package model;

import java.util.List;

import gem.Gem;
import model.Cell;

public class HalfCircle extends Cell {
	private int position;
	private List<Gem> gems;

	public HalfCircle(int position, boolean isUpperRow){
		super(position, isUpperRow);
	}
	
	//Phương thức thêm sỏi vào bán cầu
	public void addGem(Gem gem) {
		gems.add(gem);
	}
	
	//Phương thức xóa sỏi khỏi bán cầu
	public void removeGem(Gem gem) {
		gems.remove(gem);
	}
	
	//Phương thức lấy số sỏi trong bán cầu
	public int getGemsCount() {
		return gems.size();
	}
	
	//Phương thức kiểm tra bán cầu có rỗng không
	public boolean isEmpty() {
		return gems.isEmpty();
	}
	
}
