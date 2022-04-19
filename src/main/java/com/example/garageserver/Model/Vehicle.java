package com.example.garageserver.Model;

import java.text.ParseException;
import java.util.*;


public abstract class Vehicle {

    protected VehicleType type;
    protected String modelName;
    protected String licensePlate;
    protected float energyPercentage;
    protected Engine engine;
    protected List<Wheel> wheels;

    public Vehicle(Engine engine, String curAirPressure, String maxWheelPressure, int numOfWheels, String modelName, String licenseNumber) throws ParseException {
        this.licensePlate = licenseNumber;
        this.modelName = modelName;
        this.engine = engine;
        this.wheels = new ArrayList<>(numOfWheels);
        if (maxWheelPressure == null){
            maxWheelPressure = String.valueOf(new Random().nextFloat() * 70f);
        }
        for (int i = 0; i < numOfWheels; i++) {
            this.wheels.add(new Wheel(curAirPressure,maxWheelPressure));
        }
        energyPercentage = engine.EnergyPercentageCalc();
    }

    public VehicleType getType() {
        return type;
    }


    public void FillToMaxAir() {
        wheels.forEach(Wheel::FillMaxAir);
    }


    public Engine getEngine() {
        return engine;
    }

    public void AddEnergy(float energy) {
        getEngine().FillEnergy(energy);
        energyPercentage = engine.EnergyPercentageCalc();
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public float getEnergyPercentage() {
        energyPercentage = engine.EnergyPercentageCalc();
        return energyPercentage;
    }

    public void setEnergyPercentage(float energyPercentage) {
        this.energyPercentage = energyPercentage;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }

    public float getMaxAirPressure(){
        return wheels.get(0).getMaximumAirPressure();
    }


}