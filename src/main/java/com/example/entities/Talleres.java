package com.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    private String cp;
    private String ciudad;
    private Integer codEmpleado;
    private Double telefono;


}
