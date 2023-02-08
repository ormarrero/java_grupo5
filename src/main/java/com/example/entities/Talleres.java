package com.example.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.id.factory.internal.StandardIdentifierGeneratorFactory;

@Getter      //Métodos Getter
@Setter      //Métodos Setter
@NoArgsConstructor  //Constructor sin párametros
@AllArgsConstructor // Constructor con párametros
@ToString  // Método ToString
@Builder  // Permite objetos dinámicos con concatenación

@Entity
public class Talleres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToOne
    @JoinColumn(name = "mecanico_id")
    private Mecanico mecanico;
    private Double telefono;

    @ManyToOne
    // @JoinColumn(name = "talleres_cp")
    private Talleres talleres;  // Verificar esta relación 


}
