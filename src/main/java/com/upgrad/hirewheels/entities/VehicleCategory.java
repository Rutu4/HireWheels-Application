package com.upgrad.hirewheels.entities;
import javax.persistence.*;

@Entity
public class VehicleCategory {

    @Id
    @Column(name = "vehicle_category_id")
    private  int vehicleCategoryId;

    @Column(name = "vehicle_category_name", length = 50, nullable = false, unique = true)
    private String vehicleCategoryName;

    public int getVehicleCategoryId() {
        return vehicleCategoryId;
    }

    public void setVehicleCategoryId(int vehicleCategoryId) {
        this.vehicleCategoryId = vehicleCategoryId;
    }

    public String getVehicleCategoryName() {
        return vehicleCategoryName;
    }

    public void setVehicleCategoryName(String vehicleCategoryName) {
        this.vehicleCategoryName = vehicleCategoryName;
    }

    @Override
    public String toString() {
        return "VehicleCategory{vehicleCategoryId="+vehicleCategoryId
                +", vehicleCategoryName="+vehicleCategoryName
                +"}";
    }
}
