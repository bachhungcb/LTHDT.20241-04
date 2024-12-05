package model;

import gems.Gems;

import java.util.List;

public abstract class Cell {
    private List<Gems> gems;
    private int position;
    private boolean isUpperRow;
	public List<Gems> getGems() {
		return gems;
	}
	public void setGems(List<Gems> gems) {
		this.gems = gems;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public boolean isUpperRow() {
		return isUpperRow;
	}
	public void setUpperRow(boolean isUpperRow) {
		this.isUpperRow = isUpperRow;
	}
    
    
}
