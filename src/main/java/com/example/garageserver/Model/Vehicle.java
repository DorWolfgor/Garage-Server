package com.example.garageserver.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public abstract class Vehicle {
    protected String modelName;
    protected String licenseNumber;
    protected float energyPercentage;
    protected Engine engine;
    protected List<Wheel> wheels;

    public Vehicle(Engine engine, float maxWheelPressure, int numOfWheels,String modelName,String licenseNumber) {
        this.licenseNumber = licenseNumber;
        this.modelName = modelName;
        this.engine = engine;
        this.wheels = new ArrayList<>(numOfWheels);
        for (int i = 0; i < numOfWheels; i++) {
            this.wheels.add(new Wheel(maxWheelPressure));
        }
        this.CalcEnergyPercentage();
    }

    public void FillToMaxAir() {
        wheels.forEach(Wheel::FillMaxAir);
    }

    public void CalcEnergyPercentage() {
        energyPercentage = engine.EnergyPercentageCalc();
    }

    public Engine getEngine() {
        return engine;
    }

    public void AddEnergy(float energy) {
        getEngine().FillEnergy(energy);
        CalcEnergyPercentage();
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public float getEnergyPercentage() {
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
}