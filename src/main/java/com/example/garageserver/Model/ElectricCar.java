package com.example.garageserver.Model;

import java.text.ParseException;

public class ElectricCar extends Car {
    public ElectricCar(Engine engine, String curAirPressure, String maxWheelPressure, String modelName, String licenseNumber) throws ParseException {
        super(engine,curAirPressure, maxWheelPressure,modelName,licenseNumber);
        type = VehicleType.ElectricCar;
    }
}
