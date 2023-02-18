package com.example.repositories;

import com.example.entities.Mecanico;
import com.example.entities.Taller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {

    List<Mecanico> findAllByFullname(String fullname);
    List<Mecanico> findAllByTelefono(Integer telefono);
    List<Mecanico> findAllByFullnameAndTelefono(String fullname, Integer telefono);
    List<Mecanico> findAllByTaller(Taller taller);
}
