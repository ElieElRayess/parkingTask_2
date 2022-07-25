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
@Table(name="parking")

public class Parking {
    @Id
    private int id ;
    private String name;
    private float pricePerHour;
    private float fixedPrice;

}
