package com.example;

import com.example.entities.*;

import com.example.repositories.*;
import com.example.entities.enums.Color;
import com.example.config.SecurityConfig;
import com.example.entities.enums.Combustible;
import com.example.entities.enums.Grado;
import com.example.entities.enums.TipoAveria;
import com.example.entities.enums.TipoVehiculo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) { ApplicationContext context = SpringApplication.run(App.class, args);
        // VEHICULO
        VehiculoRepository vehiculoRepo = context.getBean(VehiculoRepository.class);

        Vehiculo vehiculo1 = new Vehiculo(null,  "Plaid AWD", "Tesla", TipoVehiculo.COCHE, "asd123", Color.AMARILLO, Combustible.ELECTRICO, 2019);
        Vehiculo vehiculo2 = new Vehiculo(null,  "BZ4X", "Toyota",TipoVehiculo.COCHE, "Plñ695", Color.NEGRO, Combustible.ELECTRICO, 2019);
        Vehiculo vehiculo3 = new Vehiculo(null,  "Plaid AWD", "Tesla",TipoVehiculo.COCHE, "qwe456", Color.AZUL, Combustible.GASOLINA, 2020);
        Vehiculo vehiculo4 = new Vehiculo(null,  "Model3", "Tesla",TipoVehiculo.CAMION, "a-d44t0", Color.BLANCO, Combustible.GASOIL, 2022);
        Vehiculo vehiculo5 = new Vehiculo(null,  "Model3", "Tesla",TipoVehiculo.MOTO, "W21ER2", Color.ROJO, Combustible.GASOLINA, 2021);
        Vehiculo vehiculo6 = new Vehiculo(null,  "BZ4X", "Toyota",TipoVehiculo.COCHE, "Plñ695", Color.NEGRO, Combustible.ELECTRICO, 2020);
        Vehiculo vehiculo7 = new Vehiculo(null,  "BZ4X", "Toyota",TipoVehiculo.COCHE, "Plñ695", Color.NEGRO, Combustible.ELECTRICO, 2021);
        Vehiculo vehiculo8 = new Vehiculo(null,  "BZ4X", "Toyota",TipoVehiculo.COCHE, "Plñ695", Color.NEGRO, Combustible.ELECTRICO, 2022);
        vehiculoRepo.saveAll(List.of(vehiculo1,vehiculo2, vehiculo3, vehiculo4, vehiculo5, vehiculo6, vehiculo7, vehiculo8));



        // CLIENTE-ADDRESS:
        AddressRepository addressRepo = context.getBean(AddressRepository.class);

        Address address1 = new Address(null, "La Rosa", 1, "Madrid", 10);
        Address address2 = new Address(null, "La Piedra", 10, "Valencia", 12);
        Address address3 = new Address(null,"El casal",12,"Alicante",14);
        Address address4 = new Address(null,"San Felipe",31,"Valencia",19);
        
        addressRepo.saveAll(List.of(address1,address2, address3, address4));
    
        ClienteRepository clienteRepo = context.getBean(ClienteRepository.class);
        
        Cliente cliente1 = new Cliente(null,"Jésus Peña Peña", address1, "arm@gmail.com","777788555L",698524789,vehiculo1);
        Cliente cliente2 = new Cliente(null,"María Perez Soto", address2, "lug@gmail.com", "35874895Ñ",698547145,vehiculo2);
        Cliente cliente3 = new Cliente(null,"Raul Luz Casals",address1,"kkkuhg@gmail.com","6666652241P",555221478,vehiculo3);
        Cliente cliente4 = new Cliente(null,"Luis Osma Perez",address1,"kkkhhbb@gmail.com","444182241O",777441152,vehiculo4);
        Cliente cliente5 = new Cliente(null,"Oscar Reyes Medina",address2,"gggr@gmail.com","44114415I",695231478,vehiculo5);

        clienteRepo.saveAll(List.of(cliente1,cliente2, cliente3,cliente4, cliente5));





        // TALLER:
        TallerRepository tallerRepo = context.getBean(TallerRepository.class);



        Taller taller1 = new Taller(null,"Norauto",address3,612345678);
        Taller taller2 = new Taller(null,"El supercoche",address4,687654321);

        tallerRepo.saveAll(List.of(taller1,taller2));




        // MECÁNICO:

        MecanicoRepository mecanicoRepo = context.getBean(MecanicoRepository.class);

        Mecanico mecanico1 = new Mecanico(1L,"Luis Carrasco Encinas",600112233,taller1);
        Mecanico mecanico2 = new Mecanico(2L,"Nando Domínguez Noriega",624356879,taller1);
        Mecanico mecanico3 = new Mecanico(3L,"Tomás Pedraza Navarro",680935214,taller2);
        Mecanico mecanico4 = new Mecanico(4L,"Antonio Sánchez de la Parra",655678207,taller2);
        mecanicoRepo.saveAll(List.of(mecanico1,mecanico2,mecanico3,mecanico4));

        // AVERIA


        AveriaRepository averiaRepo = context.getBean(AveriaRepository.class);


        Averia averia1 = new Averia(null, TipoAveria.ELECTRICO, "averia1", LocalDateTime.parse("2007-12-03T10:15:30"), Grado.ALTO);
        Averia averia2 = new Averia(null, TipoAveria.GOLPE, "averia2", LocalDateTime.parse("2008-12-03T10:15:30"), Grado.MEDIO);
        Averia averia3 = new Averia(null, TipoAveria.RUPTURA, "averia3", LocalDateTime.parse("2009-12-03T10:15:30"), Grado.ALTO);

        averiaRepo.saveAll(List.of(averia1, averia2, averia3));
        
        // FACTURA:
        FacturaRepository facturaRepo = context.getBean(FacturaRepository.class);
    
        Factura factura1 = new Factura(null,   2600.5,cliente1, taller1,averia1);
        Factura factura2 = new Factura(null,  2000.9,cliente2, taller2,averia2);
        Factura factura3 = new Factura(null,  1000.0,cliente3, taller1,averia3);
        Factura factura4 = new Factura(null,  750.8,cliente4, taller2,averia2);
        Factura factura5 = new Factura(null,  1500.9,cliente5, taller1,averia1);
    
        facturaRepo.saveAll(List.of(factura1, factura2, factura3, factura4, factura5));
        
        
        //  CITA

        CitaRepository citaRepo = context.getBean(CitaRepository.class);


        Cita cita1 = new Cita(null,cliente1, LocalDateTime.of(2023,2,21,17,35,22),averia2,vehiculo2,taller1);
        Cita cita2 = new Cita(null,cliente2, LocalDateTime.of(2023,2,25,13,45,54),averia1,vehiculo1,taller2);
        Cita cita3 = new Cita(null,cliente3, LocalDateTime.of(2023,2,25,13,45,54),averia3,vehiculo3,taller1);
        Cita cita4 = new Cita(null,cliente4, LocalDateTime.of(2023,2,25,13,45,54),averia2,vehiculo5,taller2);
        Cita cita5 = new Cita(null,cliente5, LocalDateTime.of(2023,2,25,13,45,54),averia1,vehiculo4,taller1);

        citaRepo.saveAll(List.of(cita1, cita2, cita3, cita4, cita5));

        // USER
        var userRepo = context.getBean(UserEntityRepository.class);
        var passwordEncoder = context.getBean(PasswordEncoder.class);

        UserEntity user1 = new UserEntity(null, "Jose Ignacio", "joigarja@gmail.com", passwordEncoder.encode("admin"));
        UserEntity user2 = new UserEntity(null, "Javier", "elboop86@gmail.com", passwordEncoder.encode("admin"));
        UserEntity user3 = new UserEntity(null, "Roberto", "robertron561@gmail.com ", passwordEncoder.encode("admin"));
        UserEntity user4 = new UserEntity(null, "Oscar", "ormarrerom2402@gmail.com.com", passwordEncoder.encode("admin"));
        UserEntity user5 = new UserEntity(null, "Cristina", "cristina.bustamanterunde@gmail.com", passwordEncoder.encode("admin"));

        userRepo.saveAll(List.of(user1, user2, user3, user4, user5));

    }
}