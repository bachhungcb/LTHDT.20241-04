package gem;

import model.Cell;

public class BigGem extends Gem {
    private int value;

    // Constructor
    public BigGem(Cell position, int value) {
        this.position = position;
        this.value = value;
    }

    // Implement getValue
    @Override
    public int getValue() {
        return value;
    }

    // Implement getPosition
    @Override
    public Cell getPosition() {
        return position;
    }

    // Implement toString
    @Override
    public String toString() {
        return "BigGem{" +
               "position=" + position +
               ", value=" + value +
               '}';
    }
}
