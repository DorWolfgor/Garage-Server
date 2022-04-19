package com.example.garageserver.Controller;
import com.example.garageserver.Model.*;
import com.example.garageserver.Service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;


@RestController
public class GarageController {

    private GarageService garageService = new GarageService();

    @RequestMapping(value = "/vehicles",method = RequestMethod.GET)
    public List<Vehicle> GetAllVehicles(@RequestParam(required = false) String[] sort_by)
    {
        if(sort_by == null){
            return garageService.GetVehicles();
        }
        else{
            return garageService.SortVehicles(sort_by);
        }
    }

    @RequestMapping(value = "/vehicles/{licensePlate}",method = RequestMethod.GET)
    public Vehicle GetVehicle(@PathVariable String licensePlate)
    {
        return garageService.GetVehicle(licensePlate);
    }

    @RequestMapping(value = "/vehicles",method = RequestMethod.POST,consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicle AddVehicle(@RequestBody Map<String,String> params)
    {
        String curAirPressure = params.get("curAirPressure");
        String maxAirPressure = params.get("maxAirPressure");
        String currentEnergy = params.get("currentEnergy");
        String maxEnergy = params.get("maxEnergy");
        String vehicleType = params.get("type");
        String modelName = params.get("modelName");
        String licenseNumber = params.get("licensePlate");
        return garageService.AddVehicle(curAirPressure,maxAirPressure,currentEnergy,maxEnergy,vehicleType,modelName,licenseNumber);
    }

    @RequestMapping(value = "vehicles/{licensePlate}/addEnergy/{energy}",method = RequestMethod.POST)
    public void AddEnergy(@PathVariable String licensePlate,@PathVariable String energy)
    {
            garageService.AddEnergy(licensePlate,energy);
    }

    @RequestMapping(value = "vehicles/{licensePlate}/InflateWheelsToMax",method = RequestMethod.POST)
    public void InflateWheelsToMax(@PathVariable String licensePlate)
    {
        garageService.InflateWheelsToMax(licensePlate);
    }
}