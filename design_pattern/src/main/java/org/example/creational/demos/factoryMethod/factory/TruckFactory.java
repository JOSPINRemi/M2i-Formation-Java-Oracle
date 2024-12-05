package org.example.creational.demos.factoryMethod.factory;

import org.example.creational.demos.factoryMethod.entity.Truck;
import org.example.creational.demos.factoryMethod.entity.Vehicle;

public class TruckFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Truck();
    }
}
