package com.upgrad.hirewheels.validator;

import com.upgrad.hirewheels.dto.VehicleDto;
import com.upgrad.hirewheels.exceptions.APIException;
import com.upgrad.hirewheels.exceptions.FuelTypeDetailsNotFoundException;
import com.upgrad.hirewheels.exceptions.LocationDetailsNotFoundException;
import com.upgrad.hirewheels.exceptions.VehicleSubcategoryDetailsNotFoundException;
import com.upgrad.hirewheels.services.FuelTypeServiceImpl;
import com.upgrad.hirewheels.services.LocationServiceImpl;
import com.upgrad.hirewheels.services.VehicleSubcategoryService;
import com.upgrad.hirewheels.services.VehicleSubcategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class VehicleValidatorImpl {

    @Autowired
    FuelTypeServiceImpl fuelTypeService;

    @Autowired
    LocationServiceImpl locationService;

    @Autowired
    VehicleSubcategoryServiceImpl vehicleSubcategoryService;


    public void validateVehicle(VehicleDto vehicleDto) throws APIException, FuelTypeDetailsNotFoundException, LocationDetailsNotFoundException, VehicleSubcategoryDetailsNotFoundException {

       if(vehicleDto.getVehicleImageUrl()==null || vehicleDto.getVehicleImageUrl().length()<=0){
           throw  new APIException("Invalid image url");
       }
       if(vehicleDto.getAvailabilityStatus()!=0 || vehicleDto.getAvailabilityStatus()!=1){
           throw new APIException("Invalid available status");
       }
       if(vehicleDto.getColor()==null || vehicleDto.getColor().length()<=0){
           throw new APIException("Invalid color");
       }
       if(vehicleDto.getVehicleModel()==null || vehicleDto.getVehicleModel().length()<=0){
           throw new APIException("Invalid vehicle model");
       }
       if(vehicleDto.getVehicleNumber()==null || vehicleDto.getVehicleNumber().length()<=0){
           throw new APIException("invalid vehicle number");
       }
       if(vehicleDto.getFuelTypeId()<=0){
           throw new APIException("Invalid fuelType id");
       }
       if(vehicleDto.getLocationId()<=0){
           throw new APIException("Invalid location id");
       }
       if(vehicleDto.getVehicleSubcategoryId()<=0){
           throw new APIException("Invalid vehicle subcategory id");
       }
       if(fuelTypeService.getFuelTypeDetails(vehicleDto.getLocationId()).getFuelType()==null)
           throw new APIException("Invalid fuel type name");
       if(locationService.getLocationDetails(vehicleDto.getLocationId()).getLocationName()==null)
           throw new APIException("Invalid Location name");
       if(vehicleSubcategoryService.getVehicleSubcategoryDetails(vehicleDto.getVehicleSubcategoryId()).getVehicleSubcategoryName()==null)
            throw new APIException("Invalid Vehicle Subvategory Name");
    }
}
