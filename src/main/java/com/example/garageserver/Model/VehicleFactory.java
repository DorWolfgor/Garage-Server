package com.example.garageserver.Model;

public class VehicleFactory {
    public static Vehicle CreateVehicle (VehicleType vehicleType, float maxEnergy, float maximumAirPressure,String modelName,String licenseNumber) throws Exception
    {
        Vehicle newVehicle;

        switch (vehicleType)
        {
            case GasMotorcycle:
                newVehicle = new GasMotorcycle(new GasEngine(maxEnergy),maximumAirPressure,modelName,licenseNumber);
                break;
            case ElectricMotorcycle:
                newVehicle = new ElectricMotorcycle(new ElectricEngine(maxEnergy),maximumAirPressure,modelName,licenseNumber);
                break;
            case GasCar:
                newVehicle = new GasCar(new GasEngine(maxEnergy),maximumAirPressure,modelName,licenseNumber);
                break;
            case ElectricCar:
                newVehicle = new ElectricCar(new ElectricEngine(maxEnergy),maximumAirPressure,modelName,licenseNumber);
                break;
            case Truck:
                newVehicle = new Truck(new GasEngine(maxEnergy),maximumAirPressure,modelName,licenseNumber);
                break;
            default:
                throw new Exception("Factory Exception, Invalid Vehicle type");
        }

        return newVehicle;
    }

}
