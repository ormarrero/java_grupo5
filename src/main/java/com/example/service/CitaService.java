package com.example.service;


import com.example.entities.Cita;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CitaService {

    // crud
    List<Cita> findAll();
    Optional<Cita> findById(Long id);
    List<Cita> findAllByFechaHora(LocalDateTime fechaHora);
    Cita save(Cita cita);
    void deleteById(Long id);
}