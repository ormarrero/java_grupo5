package com.example.repository;

import com.example.entities.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {
}
