package model;

public interface Pickable {
    public default boolean isPickable(){
        return false;
    }
}
