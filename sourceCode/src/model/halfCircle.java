package model;

import java.util.List;

import gems.Gems;

public class halfCircle extends Cell {	
	
	//Phương thức thêm sỏi vào bán cầu
	public void addGem(Gems gem) {
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
	
	//Phương thức kiểm tra bán cầu có rỗng không
	public boolean isEmpty() {
		return gems.isEmpty();
	}
}
