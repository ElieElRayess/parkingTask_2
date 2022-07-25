package com.example.parkingTask2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="client")
@Entity
public class Client {
    @Id @GeneratedValue
    private int id;
    private String name;
    private String ccInfo;
    private String carType;
    private String parking;
    private int parkingSlot;
    private LocalTime arrivalTime;
}
