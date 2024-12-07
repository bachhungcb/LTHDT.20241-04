package gem;

import model.Cell;

public class SmallGem extends Gem {
	private int value = 1;
	public SmallGem(Cell position) {
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
