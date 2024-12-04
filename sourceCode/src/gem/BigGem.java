package gems;

import model.Cell;

public class BigGems extends Gems {
    private int value;

    // Constructor
    public BigGems(Cell position, int value) {
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
        return "BigGems{" +
               "position=" + position +
               ", value=" + value +
               '}';
    }
}
