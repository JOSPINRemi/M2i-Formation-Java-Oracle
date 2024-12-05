package org.example.creational.demos.factoryMethod.factory;

import org.example.creational.demos.factoryMethod.entity.Car;
import org.example.creational.demos.factoryMethod.entity.Vehicle;

public class CarFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}
