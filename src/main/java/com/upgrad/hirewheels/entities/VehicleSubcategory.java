package com.upgrad.hirewheels.entities;
import javax.persistence.*;

@Entity
public class VehicleSubcategory {

    @Id
    @GeneratedValue
    @Column(name = "vehicle_subcategory_id")
    private int vehicleSubcategoryId;

    @Column(name = "vehicle_subcategory_name", length = 50, nullable = false, unique = true)
    private String vehicleSubcategoryName;

    @Column(name = "price_per_day",precision = 10, scale = 2, nullable = false)
    private float pricePerDay;

    public int getVehicleSubcategoryId() {
        return vehicleSubcategoryId;
    }

    public void setVehicleSubcategoryId(int vehicleSubcategoryId) {
        this.vehicleSubcategoryId = vehicleSubcategoryId;
    }

    public String getVehicleSubcategoryName() {
        return vehicleSubcategoryName;
    }

    public void setVehicleSubcategoryName(String vehicleSubcategoryName) {
        this.vehicleSubcategoryName = vehicleSubcategoryName;
    }

    public float getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(float pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {
        return "VehicleSubcategory{vehicleSubcategoryId="+vehicleSubcategoryId
                +", vehicleSubcategoryName="+vehicleSubcategoryName
                +", pricePerDay="+pricePerDay
                +"}";
    }
}
