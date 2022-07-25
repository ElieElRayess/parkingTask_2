package com.example.parkingTask2.dto;

import lombok.*;

import java.time.LocalTime;

@Data
public class ClientDTO {
    private int id;
    private String name;
    private String ccInfo;
    private String carType;
    private String parking;
//    private int parkingSlot;
//    private LocalTime arrivalTime;
}
