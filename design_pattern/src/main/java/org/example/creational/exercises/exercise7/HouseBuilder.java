package org.example.creational.exercises.exercise7;

public interface HouseBuilder {
    void setFloorNumber(int floorNumber);
    void setRoofType(String roomType);
    void setPool(boolean pool);
    House build();
}
