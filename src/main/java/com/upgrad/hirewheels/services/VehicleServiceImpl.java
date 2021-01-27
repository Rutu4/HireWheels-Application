package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.BookingDao;
import com.upgrad.hirewheels.dao.VehicleCategoryDao;
import com.upgrad.hirewheels.dao.VehicleDao;
import com.upgrad.hirewheels.dao.VehicleSubcategoryDao;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.entities.VehicleCategory;
import com.upgrad.hirewheels.entities.VehicleSubcategory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class VehicleServiceImpl implements VehicleService{

    @Autowired
    VehicleDao vehicleDao;

    @Autowired
    VehicleCategoryDao vehicleCategoryDao;

    @Autowired
    VehicleSubcategoryDao vehicleSubcategoryDao;

    @Autowired
    BookingDao bookingDao;

    @Override
    public List<Vehicle> getAllVehicles(){
        return vehicleDao.findAll();
    }

    public List<Vehicle> getAvailableVehicles(String category, String location, ChronoLocalDate pickupDate,
                                              ChronoLocalDate dropoffDate){

        List<Vehicle> vehicles=vehicleDao.findAll();

        List<Vehicle> availableVehicles=new ArrayList<>();
        for(Vehicle v: vehicles){
            if(v.getAvailabilityStatus()==1){
                if(v.getVehicleSubcategory().getVehicleCategory().getVehicleCategoryName()==category){
                    if(v.getLocation().getLocationName()==location){
                       Set<Booking> b=v.getBookings();
                       for(Booking booking: b){
                           if(booking.getPickupDate().compareTo(pickupDate)<0){
                               if(booking.getDropoffDate().compareTo(pickupDate)<0){
                                   availableVehicles.add(v);
                               }else if(booking.getPickupDate().compareTo(pickupDate)>0){
                                   if(booking.getDropoffDate().compareTo(dropoffDate)>0){
                                       availableVehicles.add(v);
                                   }
                               }
                           }
                           if(booking==null){
                               availableVehicles.add(v);
                           }
                       }
                    }
                }
            }
        }

        return availableVehicles;


    }


}
