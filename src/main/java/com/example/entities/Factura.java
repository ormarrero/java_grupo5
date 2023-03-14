package com.example.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter //Para los métodos Get
@Setter //Para los métodos Set
@NoArgsConstructor //Para el constructor sin argumentos
@AllArgsConstructor //Para el constructor con argumentos
@ToString //Para el método toString
@Builder //Para el diseño
@Entity //Clase entidad
public class Factura { //Nombre de la clase

    @Id //Es la etiqueta del identificador
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Valor único
    private Long id;
    private Double monto;
    @OneToOne //Asociar con otra clase uno a uno
    @ToString.Exclude
    @JoinColumn(name = "cliente_id") //Asociar con identificador de la tabla destino
    private Cliente cliente;
    @OneToOne
    @ToString.Exclude
    @JoinColumn(name = "taller_id")
    private Taller taller;
    @OneToOne
    @ToString.Exclude
    @JoinColumn(name = "averia_id")
    private Averia averia;

}