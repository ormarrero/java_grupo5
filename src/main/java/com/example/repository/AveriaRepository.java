package com.example.repository;

import com.example.entities.Averia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AveriaRepository extends JpaRepository<Averia, Long> {

    // Buscar por id


}