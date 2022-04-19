package com.example.garageserver.App;

import com.example.garageserver.Controller.GarageController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = GarageController.class)
public class GarageServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GarageServerApplication.class, args);
    }

}
