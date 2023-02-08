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
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private String marca;
    private Tipo tipo;
    private String matricula;
    private Color color;
    private Combustible combustible;
    private Integer year;
}
