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

    private String cp;
    private String ciudad;
    private Integer codEmpleado;
    private Double telefono;

    @ManyToOne
    // @JoinColumn(name = "talleres_cp")
    private Talleres talleres;


}
