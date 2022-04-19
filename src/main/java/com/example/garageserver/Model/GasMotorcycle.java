package com.example.garageserver.Model;

import java.text.ParseException;

public class GasMotorcycle extends Motorcycle {

    public GasMotorcycle(Engine engine, String curAirPressure, String maxWheelPressure, String modelName, String licenseNumber) throws ParseException {
        super(engine,curAirPressure, maxWheelPressure,modelName,licenseNumber);
        type = VehicleType.GasMotorcycle;
    }


}
