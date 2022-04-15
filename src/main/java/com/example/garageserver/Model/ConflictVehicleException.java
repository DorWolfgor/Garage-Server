package com.example.garageserver.Model;

public class ConflictVehicleException extends RuntimeException{
    public ConflictVehicleException(){
        super("The vehicle has the same license plate as one of the vehicles in the garage.");
    }
}
