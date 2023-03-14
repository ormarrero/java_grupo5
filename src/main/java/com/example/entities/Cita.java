package com.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @ToString.Exclude
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    private LocalDateTime fechaHora;
    @OneToOne
    @ToString.Exclude
    @JoinColumn(name = "averia_id")
    private Averia averia;
    @OneToOne
    @ToString.Exclude
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

    @OneToOne
    @ToString.Exclude
    @JoinColumn(name = "taller_id")
    private Taller taller;

}