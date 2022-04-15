package com.example.garageserver.Model;

public abstract class Car extends Vehicle {
    public Car(Engine engine, float maxWheelPressure,String modelName,String licenseNumber) {
        super(engine, maxWheelPressure, 4,modelName,licenseNumber);
    }
}
