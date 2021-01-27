package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.Vehicle;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleDao extends JpaRepository<Vehicle, Integer> {

     List<Vehicle> findAll();
}
