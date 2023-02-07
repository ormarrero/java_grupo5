package com.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter      //Métodos Getter
@Setter      //Métodos Setter
@NoArgsConstructor  //Constructor sin párametros
@AllArgsConstructor // Constructor con párametros
@ToString  // Método ToString
@Builder  // Permite objetos dinámicos con concatenación
@Entity

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String nombreCompleto;
    private String Address;
    private String email;
    private String nif;
    private Double telefono;

}
