package com.example;

import com.example.entities.*;
import com.example.repository.PresupuestoRepository;
import com.example.repository.VehiculoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) { ApplicationContext context = SpringApplication.run(App.class, args);

        // VEHICULO
        VehiculoRepository vehiculoRepo = context.getBean(VehiculoRepository.class);

        Vehiculo vehiculo1 = new Vehiculo(null,  "Plaid AWD", "Tesla",TipoVehiculo.COCHE, "asd123", Color.AMARILLO, Combustible.ELÉCTRICO, 2021);
        Vehiculo vehiculo2 = new Vehiculo(null,  "M Competition", "BMW",TipoVehiculo.COCHE, "qwe456", Color.AZUL, Combustible.GASOLINA, 2020);
        Vehiculo vehiculo3 = new Vehiculo(null,  "CB 125F", "HONDA",TipoVehiculo.MOTO, "W21ER2", Color.ROJO, Combustible.GASOLINA, 2019);
        Vehiculo vehiculo4 = new Vehiculo(null,  "S-Way", "Iveco",TipoVehiculo.CAMIÓN, "a-d44t0", Color.BLANCO, Combustible.GASOIL, 2020);
        Vehiculo vehiculo5 = new Vehiculo(null,  "BZ4X", "Toyota",TipoVehiculo.COCHE, "Plñ695", Color.NEGRO, Combustible.ELÉCTRICO, 2023);
        vehiculoRepo.saveAll(List.of(vehiculo1, vehiculo2, vehiculo3, vehiculo4, vehiculo5));

        // PRESUPUESTO:
        PresupuestoRepository presupuestoRepo = context.getBean(PresupuestoRepository.class);

        Presupuesto presupuesto1 = new Presupuesto(null,   2600.5);
        Presupuesto presupuesto2 = new Presupuesto(null,  2000.9);
        Presupuesto presupuesto3 = new Presupuesto(null,  1000.0);
        Presupuesto presupuesto4 = new Presupuesto(null,  750.8);
        Presupuesto presupuesto5 = new Presupuesto(null,  1500.9);
        presupuestoRepo.saveAll(List.of(presupuesto1, presupuesto2, presupuesto3, presupuesto4, presupuesto5));
    }
}
