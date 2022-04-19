package com.example.garageserver.Model;

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
        if (CheckIfInGarage(vehicle.getLicensePlate()))
        {
            throw new ConflictVehicleException();
        }
        vehiclesInGarage.put(vehicle.getLicensePlate(),vehicle);
        return vehicle;
    }

    public List<Vehicle> sortVehicles(String[] filters) {
        Comparator<Vehicle> compareByFilters = sortByFilters(filters);
        List<Vehicle> sorted = new ArrayList<>(vehiclesInGarage.values());
        Collections.sort(sorted,compareByFilters);
        return sorted;
    }

    public Comparator<Vehicle> sortByFilters(String[] filters){
        Comparator<Vehicle> filter = null;
        for(int i=0;i<filters.length;i++) {
            if(i==0){
                filter = sortByFilter(filters[i]);
            }
            else{
                filter.thenComparing((sortByFilter(filters[i])));
            }
        }
        return filter;
    }

    public Comparator<Vehicle> sortByFilter(String filter){
        switch(filter) {
            case "type":
                return Comparator.comparing(Vehicle::getType);
            case "modelName":
                return Comparator.comparing(Vehicle::getModelName);
            case "licensePlate":
                return Comparator.comparing(Vehicle::getLicensePlate);
            case "energyPercentage":
                return Comparator.comparing(Vehicle::getEnergyPercentage);
            case "maxAirPressure":
                return Comparator.comparing(Vehicle::getMaxAirPressure);
            default:
                throw new IllegalArgumentException("The filter is invalid");
        }
    }
}
