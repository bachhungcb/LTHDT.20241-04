package gems;

import model.Cell;

public abstract class Gems {
    // nếu để là cell private thì k thể truy cập từ lớp con khác được đk 
    protected Cell position;

    public abstract int getValue();
    public abstract Cell getPosition();
    public abstract String toString();
}
