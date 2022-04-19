package com.example.garageserver.Model;

import java.text.ParseException;

public abstract class Car extends Vehicle {
    public Car(Engine engine, String curAirPressure, String maxWheelPressure, String modelName, String licenseNumber) throws ParseException {
        super(engine,curAirPressure, maxWheelPressure, 4,modelName,licenseNumber);
    }
}
