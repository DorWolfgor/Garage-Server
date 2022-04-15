package com.example.garageserver.Controller;
import com.example.garageserver.Model.*;
import com.example.garageserver.Service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
public class GarageController {

    @Autowired
    private GarageService garageService;

    @RequestMapping(value = "/vehicles",method = RequestMethod.GET)
    public List<Vehicle> GetAllVehicles()
    {
        return garageService.GetVehicles();
    }

    @RequestMapping(value = "/vehicles/{licensePlate}",method = RequestMethod.GET)
    public Vehicle GetVehicle(@PathVariable String licensePlate)
    {
        return garageService.GetVehicle(licensePlate);
    }

    @RequestMapping(value = "/vehicles",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicle AddVehicle(@RequestBody Vehicle vehicle)
    {
        return garageService.AddVehicle(vehicle);
    }

    @RequestMapping(value = "vehicles/{licensePlate}/addEnergy/{energy}",method = RequestMethod.POST)
    public void AddEnergy(@PathVariable String licensePlate,@PathVariable String energy)
    {
            garageService.AddEnergy(licensePlate,energy);
    }

    @RequestMapping(value = "vehicles/{licensePlate}/InflateWheelsToMax/",method = RequestMethod.POST)
    public void InflateWheelsToMax(@PathVariable String licensePlate)
    {
        garageService.InflateWheelsToMax(licensePlate);
    }

//    @RequestMapping(value = "/vehicles/sorting",method = RequestMethod.GET)
//    public List<Vehicle> SortVehicles(@RequestBody String[] properties){
//        Comparator<Vehicle> compare = Comparator.comparing(properties.)
//    }
}
