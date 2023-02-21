package com.example.repositories;

import com.example.entities.Averia;
import com.example.entities.enums.Grado;
import com.example.entities.enums.TipoAveria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AveriaRepository extends JpaRepository<Averia, Long> {
    List<Averia> findAllByTipo(TipoAveria tipo);
    List<Averia> findAllByDescripcion(String descripcion);
    List<Averia> findAllByFechaHora(LocalDateTime fechaHora);
    List<Averia> findAllByGrado(Grado grado);
}