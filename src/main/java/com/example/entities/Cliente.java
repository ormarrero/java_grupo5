package com.example.entities;

import jakarta.persistence.*;
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
    private Long id;

    private String nombreCompleto;
    @OneToOne
    @ToString.Exclude
    @JoinColumn(name = "address_id")
    private Address address;
    private String email;
    private String nif;
    private Integer telefono;
    @OneToOne
    @ToString.Exclude
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

}