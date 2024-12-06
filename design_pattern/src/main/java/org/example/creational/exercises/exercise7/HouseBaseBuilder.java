package org.example.creational.exercises.exercise7;

public class HouseBaseBuilder implements HouseBuilder {
    private House house;

    public HouseBaseBuilder() {
        house = new House();
    }

    @Override
    public void setFloorNumber(int floorNumber) {
        house.setFloorNumber(floorNumber);
    }

    @Override
    public void setRoofType(String roomType) {
        house.setRoofType(roomType);
    }

    @Override
    public void setPool(boolean pool) {
        house.setPool(pool);
    }

    @Override
    public House build() {
        return house;
    }
}
