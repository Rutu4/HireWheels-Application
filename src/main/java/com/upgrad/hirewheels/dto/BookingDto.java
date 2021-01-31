package com.upgrad.hirewheels.dto;

import com.upgrad.hirewheels.entities.Location;
import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.entities.Vehicle;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class BookingDto {
    private int bookingId;

    private LocalDate pickupDate;

    private LocalDate dropoffDate;

    private LocalDate bookingDate;

    private float amount;


    private Location location;


    private int vehicle;

    private int user;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDate getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(LocalDate dropoffDate) {
        this.dropoffDate = dropoffDate;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getVehicle() {
        return vehicle;
    }

    public void setVehicle(int vehicle) {
        this.vehicle = vehicle;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
}
