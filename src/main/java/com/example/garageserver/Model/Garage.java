package com.example.garageserver.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

public class Garage {

    private final Hashtable<String, Vehicle> vehiclesInGarage;

    public Garage () {
        vehiclesInGarage = new Hashtable<>();
    }

    public Hashtable<String, Vehicle> getVehiclesInGarage() {
        return vehiclesInGarage;
    }

    public List<Vehicle> getVehicles() {
        return new ArrayList<>(vehiclesInGarage.values());
    }

    public boolean CheckIfInGarage(String licensePlate)
    {
        return vehiclesInGarage.containsKey(licensePlate);
    }

    public synchronized void inflateWheelsToMax(String licensePlate) throws VehicleNotInGarageException
    {
        GetVehicle(licensePlate).FillToMaxAir();
    }

    public synchronized void AddEnergy(String licensePlate, float energy) throws VehicleNotInGarageException
    {
        GetVehicle(licensePlate).AddEnergy(energy);
    }


    public Vehicle GetVehicle(String licensePlate) throws VehicleNotInGarageException
    {
        Vehicle vehicle = vehiclesInGarage.get(licensePlate);
        if(vehicle == null){
            throw new VehicleNotInGarageException();
        }
        return vehicle;
    }

    public synchronized Vehicle AddVehicle(Vehicle vehicle) throws ConflictVehicleException
    {
        if (CheckIfInGarage(vehicle.getLicenseNumber()))
        {
            throw new ConflictVehicleException();
        }
        vehiclesInGarage.put(vehicle.getLicenseNumber(),vehicle);
        return vehicle;
    }

}
