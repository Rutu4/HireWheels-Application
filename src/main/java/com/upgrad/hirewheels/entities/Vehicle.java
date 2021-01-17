package com.upgrad.hirewheels.entities;
import javax.persistence.*;

@Entity
public class Vehicle {

    @Id
    @Column(name = "vehicle_id")
    private int vehicleId;

    @Column(name = "vehicle_model", length = 50, nullable = false)
    private String vehicleModel;

    @Column(name = "vehicle_number",length = 10, nullable = false)
    private String vehicleNumber;

    @Column(length = 50, nullable = false)
    private String color;

    @Column(name = "availability_status", length = 1, nullable = false)
    private int availabilityStatus;

    @Column(name = "vehicle_image_url", length = 500, nullable = false)
    private  String vehicleImageUrl;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(int availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getVehicleImageUrl() {
        return vehicleImageUrl;
    }

    public void setVehicleImageUrl(String vehicleImageUrl) {
        this.vehicleImageUrl = vehicleImageUrl;
    }
}
