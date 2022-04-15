package com.example.garageserver.Service;

import com.example.garageserver.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GarageService {

    private Garage garage = new Garage();

    public List<Vehicle> GetVehicles() {
        try {
            return garage.getVehicles();
        }
        catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(),ex);
        }
    }

    public Vehicle GetVehicle(String licensePlate) {
        try {
            return garage.GetVehicle(licensePlate);
        }
        catch (VehicleNotInGarageException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(),ex);
        }
        catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(),ex);
        }
    }

    public void InflateWheelsToMax(String licensePlate) {
        try {
            garage.inflateWheelsToMax(licensePlate);
        }
        catch (VehicleNotInGarageException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(),ex);
        }
        catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(),ex);
        }
    }

    public Vehicle AddVehicle(Vehicle vehicle) {
        try {
            return garage.AddVehicle(vehicle);
        }
        catch (ConflictVehicleException ex){
            throw new ResponseStatusException(HttpStatus.CONFLICT,ex.getMessage(),ex);
        }
        catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(),ex);
        }
    }

    public void AddEnergy(String licensePlate, String energy) {
        try {
            garage.AddEnergy(licensePlate,Float.parseFloat(energy));
        }
        catch (VehicleNotInGarageException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(),ex);
        }
        catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(),ex);
        }
    }

}
