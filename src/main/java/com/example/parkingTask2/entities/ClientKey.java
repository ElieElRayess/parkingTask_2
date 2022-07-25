package com.example.parkingTask2.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.security.PublicKey;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name="client_key")
public class ClientKey {
    @Id @GeneratedValue
    private int id;
    private PublicKey publicKey;

}
