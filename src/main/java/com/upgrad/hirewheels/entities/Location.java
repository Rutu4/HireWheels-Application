package com.upgrad.hirewheels.entities;
import javax.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue
    @Column(name = "location_id")
    private  int locationId;

    @Column(name = "location_name", length = 50, nullable = false)
    private String locationName;

    @Column(name = "location_address", length = 100, nullable = false)
    private String locationAddress;

    @Column(length = 6, nullable = false)
    private String pincode;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Location{locationId="+locationId
                +", locationName="+locationName
                +", locationAddress="+locationAddress
                +", pincode="+pincode
                +"}";
    }
}
