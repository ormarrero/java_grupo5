package com.example.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter // Métodos getter
@Setter // Métodos setter
@NoArgsConstructor // Constructor sin parámetros
@AllArgsConstructor // Constructor con todos los parámetros
@ToString // Método toString()
@Builder // Patrón de diseño builder, permite construir objetos dinámicamente concatenando métodos
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;
    private Integer numero;
    private String ciudad;
    private Integer cp;

}