package com.example;

import com.example.entities.*;
import com.example.repositories.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) { ApplicationContext context = SpringApplication.run(App.class, args);
        // CLIENTE-ADDRESS:
        ClienteRepository clienteRepo = context.getBean(ClienteRepository.class);
        AddressRepository addressRepo = context.getBean(AddressRepository.class);

        Address address1 = new Address(null, "La Rosa", 1, "Madrid", 10);
        Address address2 = new Address(null, "La Piedra", 10, "Valencia", 12);
        addressRepo.saveAll(List.of(address1,address2));

        Cliente cliente1 = new Cliente(1L,"Jésus Peña Peña", address1, "arm@gmail.com","777788555L",698524789);
        Cliente cliente2 = new Cliente(2L,"María Perez Soto", address2, "lug@gmail.com", "35874895Ñ",698547145);
        Cliente cliente3 = new Cliente(3L,"Raul Luz Casals",address1,"kkkuhg@gmail.com","6666652241P",555221478);
        Cliente cliente4 = new Cliente(4L,"Luis Osma Perez",address1,"kkkhhbb@gmail.com","444182241O",777441152);
        Cliente cliente5 = new Cliente(5L,"Oscar Reyes Medina",address2,"gggr@gmail.com","44114415I",695231478);
        clienteRepo.saveAll(List.of(cliente1,cliente2, cliente3,cliente4, cliente5));

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

        // MECÁNICO-TALLER:
        MecanicoRepository mecanicoRepo = context.getBean(MecanicoRepository.class);
        TallerRepository tallerRepo = context.getBean(TallerRepository.class);

        ArrayList<Mecanico> listaMecanicosTaller1 = new ArrayList<>();
        ArrayList<Mecanico> listaMecanicosTaller2 = new ArrayList<>();

        Taller taller1 = new Taller(null,"Norauto",address1,listaMecanicosTaller1,612345678);
        Taller taller2 = new Taller(null,"El supercoche",address2,listaMecanicosTaller2,687654321);
        tallerRepo.saveAll(List.of(taller1,taller2));

        Mecanico mecanico1 = new Mecanico(1L,"Luis Carrasco Encinas",600112233,taller1);
        Mecanico mecanico2 = new Mecanico(2L,"Nando Domínguez Noriega",624356879,taller1);
        Mecanico mecanico3 = new Mecanico(3L,"Tomás Pedraza Navarro",680935214,taller2);
        Mecanico mecanico4 = new Mecanico(4L,"Antonio Sánchez de la Parra",655678207,taller2);
        mecanicoRepo.saveAll(List.of(mecanico1,mecanico2,mecanico3,mecanico4));

        listaMecanicosTaller1.add(mecanico1);
        listaMecanicosTaller1.add(mecanico2);
        listaMecanicosTaller2.add(mecanico3);
        listaMecanicosTaller2.add(mecanico4);
        tallerRepo.saveAll(List.of(taller1,taller2));
        //mecanicoRepo.saveAll(List.of(mecanico1,mecanico2,mecanico3,mecanico4));














    }
}
