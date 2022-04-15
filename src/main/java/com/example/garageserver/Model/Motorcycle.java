package com.example.garageserver.Model;

public abstract class Motorcycle extends Vehicle {
    public Motorcycle(Engine engine, float maxWheelPressure,String modelName,String licenseNumber) {
        super(engine, maxWheelPressure, 2,modelName,licenseNumber);
    }
}
