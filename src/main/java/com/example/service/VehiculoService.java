package com.example.service;

import com.example.entities.Address;
import com.example.entities.Vehiculo;

import java.util.List;
import java.util.Optional;

public interface VehiculoService {
    List<Vehiculo> findAll();
    Optional<Vehiculo> findById(Long id);
    List<Vehiculo> findAllByModelo(String modelo);
    List<Vehiculo> findAllByMarca(String marca);
    List<Vehiculo> findAllByModeloAndMarca(String modelo, String marca);
    List<Vehiculo> findAllByMatricula(String matricula);
    List<Vehiculo> findAllByYear(Integer year);
    Vehiculo save(Vehiculo vehiculo);
    void deleteById(Long id);