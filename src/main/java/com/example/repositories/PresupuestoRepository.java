package com.example.repositories;

import com.example.entities.Presupuesto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresupuestoRepository extends JpaRepository<Presupuesto, Long> {
}
