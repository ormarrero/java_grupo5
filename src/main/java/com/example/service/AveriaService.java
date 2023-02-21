package com.example.service;

import com.example.entities.Averia;
import com.example.entities.Grado;
import com.example.entities.TipoAveria;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AveriaService {

    List<Averia> findAll();
    Optional<Averia> findById(Long id);
    List<Averia> findAllByTipo(TipoAveria tipo);
    List<Averia> findAllByDescripcion(String descripcion);
    List<Averia> findAllByFechaHora(LocalDateTime fecha_hora);
    List<Averia> findAllByGrado(Grado grado);
    Averia save(Averia averia);
    void deleteById(Long id);
}
