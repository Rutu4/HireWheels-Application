package com.upgrad.hirewheels.controllers;

import com.upgrad.hirewheels.dto.VehicleDto;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.VehicleDetailsNotFoundException;
import com.upgrad.hirewheels.services.VehicleServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(value="/hirewheels/v1")
public class AdminController {

    @Autowired
    VehicleServiceImpl vehicleService;

    @Autowired
    ModelMapper modelmapper;

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @PostMapping(value="/vehicles",consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newVehicle(@RequestBody VehicleDto vehicleDto) {
        Vehicle newVehicle = modelmapper.map(vehicleDto, Vehicle.class);
        Vehicle savedVehicle = vehicleService.addVehicle(newVehicle);
        VehicleDto savedVehicleDto = modelmapper.map(savedVehicle, VehicleDto.class);
        logger.debug("Accepted new vehicle details",savedVehicle);
        return new ResponseEntity<>(savedVehicleDto, HttpStatus.CREATED);
    }
    @PutMapping(value ="/vehicles/{id}",consumes =MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity changeVehicleAvailability(@PathVariable ("id") int id,
                                                    @RequestBody int availabilityStatus) throws VehicleDetailsNotFoundException {
        Vehicle vehicle= vehicleService.getVehicleDetails(id);
        vehicle.setAvailabilityStatus(availabilityStatus);
        vehicleService.addVehicle(vehicle);
        logger.debug("Update vehicle availability details : vehicle id :" + id, vehicle);
        return new ResponseEntity<>("saved",HttpStatus.OK);
    }
    }