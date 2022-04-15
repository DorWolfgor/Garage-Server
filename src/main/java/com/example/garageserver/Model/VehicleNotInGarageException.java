package com.example.garageserver.Model;

public class VehicleNotInGarageException extends RuntimeException{
    public VehicleNotInGarageException(){
        super("Vehicle not found.");
    }
}