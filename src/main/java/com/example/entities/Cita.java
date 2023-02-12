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
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "mecanico_id")
    private Mecanico mecanico;
    private LocalDateTime fecha_hora;
    @OneToOne
    @JoinColumn(name = "averia_id")
    private Averia averia;
    @OneToOne
    @JoinColumn(name = "presupuesto_id")
    private Presupuesto presupuesto;

}