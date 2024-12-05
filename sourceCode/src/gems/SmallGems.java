package gems;

import model.Cell;

public class SmallGems extends Gems {
	private int value = 5;
	public SmallGems(Cell position) {
		this.position = position;
	}
	@Override
	public int getValue() {
		return value;
	}
	@Override
	public Cell getPosition() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
