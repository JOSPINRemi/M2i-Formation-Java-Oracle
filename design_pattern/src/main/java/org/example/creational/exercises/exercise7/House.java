package org.example.creational.exercises.exercise7;

public class House {
    private int floorNumber;
    private String roofType;
    private boolean pool;

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getRoofType() {
        return roofType;
    }

    public void setRoofType(String roofType) {
        this.roofType = roofType;
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    @Override
    public String toString() {
        return "House{" +
                "floorNumber=" + floorNumber +
                ", roofType='" + roofType + '\'' +
                ", pool=" + pool +
                '}';
    }
}
