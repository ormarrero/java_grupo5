package com.example.repositories;

import com.example.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findAllByCliente(Cliente cliente);
    List<Cita> findAllByFechaHora(LocalDateTime fechaHora);
    List<Cita> findAllByAveria(Averia averia);
    List<Cita> findAllByVehiculo(Vehiculo vehiculo);
    List<Cita> findAllByTaller(Taller taller);
    List<Cita> findAllByClienteId(Long id);
    List<Cita> findAllByAveriaId(Long id);
    List<Cita> findAllByVehiculoId(Long id);
    List<Cita> findAllByTallerId(Long id);
}