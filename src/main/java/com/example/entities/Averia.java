package com.example.entities;

import com.example.entities.enums.TipoAveria;
import com.example.entities.enums.Grado;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter // Métodos getter
@Setter // Métodos setter
@NoArgsConstructor // Constructor sin parámetros
@AllArgsConstructor // Constructor con todos los parámetros
@ToString // Método toString()
@Builder // Patrón de diseño builder, permite construir objetos dinámicamente concatenando métodos

@Entity
public class Averia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TipoAveria tipo;
    private String descripcion;
    private LocalDateTime fecha_hora;
    private Grado grado;


}