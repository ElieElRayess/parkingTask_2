package com.example.parkingTask2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table
public class ParkingSlot {

    @Id @GeneratedValue
    private int slotId ;
    private String mainParking;
    private String type;
    private boolean isFree;

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "mainParking='" + mainParking + '\'' +
                ", slotId=" + slotId +
                ", type='" + type + '\'' +
                ", isFree=" + isFree +
                '}';
    }
}
