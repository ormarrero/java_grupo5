package com.example.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

@Entity
public class Presupuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double monto;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "taller_id")
    private Taller taller;

    //@OneToOne
    //@JoinColumn(name = "averia_id")
    //private Averia averia; //Se decomenta cuando esté el objeto Avería

    private Estado estado;


}
