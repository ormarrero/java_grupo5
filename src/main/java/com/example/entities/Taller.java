package com.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter      //Métodos Getter
@Setter      //Métodos Setter
@NoArgsConstructor  //Constructor sin párametros
@AllArgsConstructor // Constructor con párametros
@ToString  // Método ToString
@Builder  // Permite objetos dinámicos con concatenación

@Entity
public class Taller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    //@OneToMany
    //@JoinColumn(name = "mecanico_id")
    //private List<Mecanico> mecanico; //A falta de la decisión del resto y del mentor
    private Integer telefono;

}
