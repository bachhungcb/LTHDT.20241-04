package model;

import java.util.List;

import gems.Gems;

public class halfCircle extends Cell {
	private int position;
	private List<Gems> gems;
	
	//Phương thức thêm sỏi vào bán cầu
	public void addGem(Gems gems) {
		gems.add(gem);
	}
	
	//Phương thức xóa sỏi khỏi bán cầu
	public void removeGem(Gems gem) {
		gems.remove(gem);
	}
	
	//Phương thức lấy số sỏi trong bán cầu
	public int getGemsCount() {
		return gems.size();
	}
	
	
	public boolean isEmpty() {
		return false;
	}

}
