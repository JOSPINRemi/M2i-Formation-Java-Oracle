package org.example.creational.demos.factoryMethod;

import org.example.creational.demos.factoryMethod.entity.Vehicle;
import org.example.creational.demos.factoryMethod.factory.CarFactory;
import org.example.creational.demos.factoryMethod.factory.TruckFactory;
import org.example.creational.demos.factoryMethod.factory.VehicleFactory;

public class Main {
    public static void main(String[] args) {
        VehicleFactory carFactory = new CarFactory();
        Vehicle car = carFactory.createVehicle();
        car.drive();

        VehicleFactory truckFactory = new TruckFactory();
        Vehicle truck = truckFactory.createVehicle();
        truck.drive();
    }
}
