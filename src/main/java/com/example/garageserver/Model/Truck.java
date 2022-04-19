package com.example.garageserver.Model;

import java.text.ParseException;

public class Truck extends Vehicle {
    public Truck(Engine engine, String curAirPressure, String maxWheelPressure, String modelName, String licenseNumber) throws ParseException {
        super(engine, curAirPressure, maxWheelPressure, 16,modelName,licenseNumber);
        type = VehicleType.Truck;
    }
}
