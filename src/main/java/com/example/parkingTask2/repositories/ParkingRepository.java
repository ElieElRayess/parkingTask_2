package com.example.parkingTask2.repositories;

import com.example.parkingTask2.entities.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<Parking, Integer> {

    Parking findByName(String name);


}
