package com.example.garageserver.Model;

public class Truck extends Vehicle {
    public Truck(Engine engine, float maxWheelPressure,String modelName,String licenseNumber) {
        super(engine, maxWheelPressure, 16,modelName,licenseNumber);
    }
}
