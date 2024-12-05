package gems;

import model.Cell;

public class BigGems extends Gems {
    // Không cần khai báo value trong constructor nữa, vì giá trị luôn là 5
    private final int value = 5;

    // Constructor
    public BigGems(Cell position) {
        this.position = position;  // Chỉ cần truyền vị trí vào
    }

    // Implement getValue
    @Override
    public int getValue() {
        return value;  // Luôn trả về 5
    }

    // Implement getPosition
    @Override
    public Cell getPosition() {
        return position;  // Trả về vị trí
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
