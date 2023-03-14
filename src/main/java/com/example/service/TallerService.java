package com.example.service;

import com.example.entities.Taller;

import java.util.List;
import java.util.Optional;

public interface TallerService {

    // Operaciones Crud
    List<Taller> findAll();
    Optional<Taller> findById(Long id);
    List<Taller> findAllByNombre(String nombre);
    List<Taller> findAllByTelefono(Integer telefono);
    List<Taller> findAllByNombreAndTelefono(String nombre, Integer telefono);
    Taller save(Taller taller);
    void deleteById(Long id);
    List<Taller> findAllByAddressId(Long id);
}
