package com.example.service;


import com.example.entities.Cita;

import java.util.List;
import java.util.Optional;

public interface CitaService {

    // crud
    List<Cita> findAll();
    Optional<Cita> findById(Long id);
    List<Cita> findAllByCalle(String calle);
    List<Cita> findAllByNumero(Integer numero);
    List<Cita> findAllByCalleAndNumero(String calle, Integer numero);
    List<Cita> findAllByCiudad(String ciudad);
    List<Cita> findAllByCp(Integer cp);
    List<Cita> findAllByCiudadAndCp(String ciudad, Integer cp);
    Cita save(Cita cita);
    void deleteById(Long id);
}