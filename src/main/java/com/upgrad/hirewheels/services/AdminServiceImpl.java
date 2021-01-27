package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.VehicleDao;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.VehicleDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl {

    @Autowired
    VehicleDao vehicleDao;

    public Vehicle getVehicleDetails(int id) throws VehicleDetailsNotFoundException {
        return vehicleDao.findById(id)
                .orElseThrow(
                        () -> new VehicleDetailsNotFoundException("Vehicle not found for id: " + id)
                );
    }

    public Vehicle registerVehicle(Vehicle vehicle){
        vehicle.setAvailabilityStatus(1);
        return vehicleDao.save(vehicle);

    }


    public Vehicle changeAvailability(Vehicle vehicle, int status) throws VehicleDetailsNotFoundException{
        Vehicle savedVehicle = getVehicleDetails(vehicle.getVehicleId());
        savedVehicle.setAvailabilityStatus(status);
        return vehicleDao.save(savedVehicle);
    }
}
