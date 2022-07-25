package com.example.parkingTask2.repositories;

import com.example.parkingTask2.entities.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ParkingSlotRepository extends JpaRepository<ParkingSlot,Integer> {
}
