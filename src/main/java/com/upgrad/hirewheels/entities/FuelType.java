package com.upgrad.hirewheels.entities;
import javax.persistence.*;

@Entity
public class FuelType {

    @Id
    @GeneratedValue
    @Column(name = "fuel_type_id")
    private int fuelTypeId;

    @Column(name = "fuel_type", length = 50, unique = true, nullable = false)
    private String fuelType;

    public int getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(int fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "FuelType{fuelTypeId="+fuelTypeId
                +", fuelType"+fuelType
                +"}";
    }
}
