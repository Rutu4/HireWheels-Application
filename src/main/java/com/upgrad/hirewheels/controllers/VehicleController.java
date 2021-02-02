package com.upgrad.hirewheels.controllers;

import com.upgrad.hirewheels.dto.VehicleDto;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.VehicleDetailsNotFoundException;
import com.upgrad.hirewheels.services.VehicleServiceImpl;
import org.hibernate.annotations.NamedNativeQuery;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.NamedQuery;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value="/hirewheels/v1/vehicles")
public class VehicleController {

        @Autowired
        VehicleServiceImpl vehicleService;

        @Autowired
        ModelMapper modelmapper;

        @GetMapping(value = "/data",produces= MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity getVehicles(@PathVariable("categoryName") String categoryName,
                                          @PathVariable("pickupDate") ChronoLocalDate pickupDate,
                                          @PathVariable("dropoffDate") ChronoLocalDate dropoffDate,
                                          @PathVariable("locationId") int locationId)
                throws VehicleDetailsNotFoundException {


                if (categoryName == null || pickupDate == null || dropoffDate == null || locationId <= 0) {
                        List<Vehicle> vehicles = vehicleService.getAllVehicles();
                        List<VehicleDto> vehicleDtos = new ArrayList<>();
                        for (Vehicle vehicle : vehicles) {
                                vehicleDtos.add(modelmapper.map(vehicle, VehicleDto.class));
                        }

                        return new ResponseEntity<>(vehicleDtos, HttpStatus.OK);
                }
                Set<Vehicle> vehicles = vehicleService.getAvailableVehicles(categoryName, locationId, pickupDate, dropoffDate);
                List<VehicleDto> vehicleDtos = new ArrayList<>();
                for (Vehicle vehicle : vehicles) {
                        vehicleDtos.add(modelmapper.map(vehicle, VehicleDto.class));
                }

                return new ResponseEntity<>(vehicleDtos, HttpStatus.OK);


        }
}
