package com.example.garageserver.Service;

import com.example.garageserver.Model.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.util.List;

import static com.example.garageserver.Model.VehicleFactory.CreateVehicle;

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

    public Vehicle AddVehicle(String curAirPressure,String maxAirPressure,
                              String currentEnergy, String maxEnergy,
                              String vehicleType, String modelName,
                              String licenseNumber) {
        if(maxAirPressure == null && curAirPressure != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You need also put in maximum air pressure as query parameter if you are putting in current air pressure");
        }
        if(maxEnergy == null && currentEnergy != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You need also put in maximum energy as query parameter if you are putting in current energy");
        }
        if(licenseNumber == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You need to put in licensePlate as query parameter");
        }
        if(modelName == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You need to put in modelName as query parameter");
        }
        if(vehicleType == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You need to put in type as query parameter");
        }
        try {
            return garage.AddVehicle(CreateVehicle(VehicleType.valueOf(vehicleType),maxEnergy,curAirPressure,currentEnergy,
                    maxAirPressure,modelName,licenseNumber));
        }
        catch (ConflictVehicleException ex){
            throw new ResponseStatusException(HttpStatus.CONFLICT,ex.getMessage(),ex);
        }
        catch (ParseException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(),ex);
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

    public List<Vehicle> SortVehicles(String[] filters){
        try{
            return garage.sortVehicles(filters);
        }
        catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(),ex);
        }
    }
}
