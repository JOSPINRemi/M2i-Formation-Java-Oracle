package org.example.creational.exercises.exercise7;

public class Main {
    public static void main(String[] args) {
        HouseBuilder builder = new HouseBaseBuilder();
        builder.setFloorNumber(1);
        builder.setRoofType("Wood");
        builder.setPool(true);
        House house = builder.build();
        System.out.println(house);
    }
}
