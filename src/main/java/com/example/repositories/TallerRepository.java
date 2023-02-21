package com.example.repositories;

import com.example.entities.Address;
import com.example.entities.Mecanico;
import com.example.entities.Taller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TallerRepository extends JpaRepository<Taller, Long> {

    List<Taller> findAllByNombre(String nombre);
    List<Address> findAllByAddress(Address address);
    List<Mecanico> findAllByMecanico(Mecanico mecanico);
    List<Taller> findAllByTelefono(Integer telefono);
    List<Taller> findAllByNombreAndTelefono(String nombre, Integer telefono);

}