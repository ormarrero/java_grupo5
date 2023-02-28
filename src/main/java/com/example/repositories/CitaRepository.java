package com.example.repositories;

import com.example.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findAllByCliente(Cliente cliente);
    List<Cita> findAllByClienteId(Long id);
    List<Cita> findAllByFechaHora(LocalDateTime fechaHora);
    List<Cita> findAllByAveria(Averia averia);
    List<Cita> findAllByVehiculo(Vehiculo vehiculo);
    List<Cita> findAllByTaller(Taller taller);

    List<Cita> findByClienteId(Long id);
}
