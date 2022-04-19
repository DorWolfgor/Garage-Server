package com.example.garageserver.Model;

import java.util.Random;

public abstract class Engine {
    protected float currentEnergy;
    protected float maximumEnergyCapacity;

    public Engine(String currentEnergy,String maxEnergy) throws IllegalArgumentException {
        if(maxEnergy == null){
            maximumEnergyCapacity = new Random().nextFloat() * 70f;
        }
        else{
            setMaximumEnergyCapacity(Float.parseFloat(maxEnergy));
        }
        if(currentEnergy == null){
            this.currentEnergy = new Random().nextFloat() * maximumEnergyCapacity;
        }
        else{
            FillEnergy(Float.parseFloat(currentEnergy));
        }
    }

    private void setMaximumEnergyCapacity(float maximumEnergyCapacity) throws IllegalArgumentException {
        if (maximumEnergyCapacity < 0) {
            throw new IllegalArgumentException("The maximum energy capacity must be above 0.\n");
        }
        this.maximumEnergyCapacity = maximumEnergyCapacity;
    }
    public float getMaximumEnergyCapacity() {
            return maximumEnergyCapacity;
    }

    public void FillEnergy(float energyToAdd) throws ValueOutOfRangeException {
        if (energyToAdd < 0 || energyToAdd + currentEnergy > maximumEnergyCapacity) {
            throw new ValueOutOfRangeException(0, maximumEnergyCapacity - currentEnergy);
        }
        currentEnergy += energyToAdd;
    }

    public float getCurrentEnergy()
    {
            return currentEnergy;
    }

    public float EnergyPercentageCalc() {

        return (currentEnergy / maximumEnergyCapacity) * 100f;
    }

}
