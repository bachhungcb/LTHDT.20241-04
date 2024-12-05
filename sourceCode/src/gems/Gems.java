package gems;

import model.Cell;

public abstract class Gems {
    protected Cell position;

    public abstract int getValue();
    public abstract Cell getPosition();
    public abstract String toString();
}
