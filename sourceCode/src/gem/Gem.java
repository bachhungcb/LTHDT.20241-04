package gem;

import model.Cell;

public abstract class Gem {
    protected Cell position;

    public abstract int getValue();
    public abstract Cell getPosition();
    public abstract String toString();
}
