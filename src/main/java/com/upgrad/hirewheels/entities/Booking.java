package com.upgrad.hirewheels.entities;
import javax.persistence.*;
import  java.time.LocalDate;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    @Column(name = "booking_id")
    private int bookingId;

    @Column(name = "pickup_date", nullable = false)
    private LocalDate pickupDate;

    @Column(name = "dropoff_date", nullable = false)
    private LocalDate dropoffDate;

    @Column(name = "booking_date", nullable = false)
    private LocalDate bookingDate;

    @Column(precision = 10, scale = 2, nullable = false)
    private float amount;

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

    @Override
    public String toString() {
        return "Booking{" + "bookingId="+bookingId+
                ", pickupDate="+pickupDate
                +", dropoffDate="+dropoffDate
                +", bookingDate="+bookingDate
                +", amount="+amount
                +"}";
    }
}
