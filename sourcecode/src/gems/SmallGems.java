package gems;

import model.Cell;

public class SmallGems extends Gems {
	private int value = 1;
	public SmallGems(Cell position) {
		this.position = position;
	}
	@Override
	public int getValue() {
		return value;
	}
	@Override
	public Cell getPosition() {
		return position;
	}
	@Override
	public String toString() {
		// Co phai override method toString ?
		return null;
	}
	
}
