package com.example.garageserver.Model;

import java.text.ParseException;

public abstract class Motorcycle extends Vehicle {

    public Motorcycle(Engine engine, String curAirPressure, String maxWheelPressure, String modelName, String licenseNumber) throws ParseException {
        super(engine, curAirPressure, maxWheelPressure, 2,modelName,licenseNumber);
    }
}
