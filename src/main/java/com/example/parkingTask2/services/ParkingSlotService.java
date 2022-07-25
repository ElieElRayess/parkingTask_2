package com.example.parkingTask2.services;

import com.example.parkingTask2.entities.ParkingSlot;
import com.example.parkingTask2.repositories.ParkingSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ParkingSlotService {

    @Autowired
    private ParkingSlotRepository parkingSlotRepository;

    public void updateParkingSlot(ParkingSlot pSlot){
        parkingSlotRepository.save(pSlot);
    }


}
