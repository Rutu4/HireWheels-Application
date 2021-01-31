package com.upgrad.hirewheels.controllers;

import com.upgrad.hirewheels.dto.BookingDto;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.services.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/hirewheels/v1/bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping(value="/booking",consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newBooking(@RequestBody BookingDto bookingDto) throws Exception {
        Booking newBooking = modelMapper.map(bookingDto, Booking.class);
        Booking savedBooking = bookingService.addBooking(newBooking);
        BookingDto savedBookingDTO = modelMapper.map(savedBooking, BookingDto.class);
        return new ResponseEntity<>(savedBookingDTO, HttpStatus.CREATED);
    }

}
