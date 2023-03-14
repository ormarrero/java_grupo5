package com.example.service;

import com.example.entities.Mecanico;

import java.util.List;
import java.util.Optional;

public interface MecanicoService {

    // Operaciones Crud
    List<Mecanico> findAll();
    Optional<Mecanico> findById(Long id);
    List<Mecanico> findAllByFullname(String fullname);
    List<Mecanico> findAllByTelefono(Integer telefono);
    List<Mecanico> findAllByFullnameAndTelefono(String fullname, Integer telefono);
    Mecanico save(Mecanico mecanico);
    void deleteById(Long id);
    List<Mecanico> findAllByTallerId(Long id);

    // Lógica de negocio
}
