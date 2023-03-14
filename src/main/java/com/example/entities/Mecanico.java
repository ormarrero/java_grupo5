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
public class Mecanico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    private Integer telefono;
    @OneToOne
    @ToString.Exclude
    @JoinColumn(name = "taller_id")
    private Taller taller;
}