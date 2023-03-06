package com.example.service;


import com.example.entities.*;
import com.example.entities.enums.TipoAveria;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CitaService {
    
    // crud
    List<Cita> findAll();
    Optional<Cita> findById(Long id);
    List<Cita> findAllByFechaHora(LocalDateTime fechaHora);

    Object findAllByCliente(Cliente cliente);

    Object findAllByVehiculo(Vehiculo vehiculo);
    
    Cita save(Cita cita);
    void deleteById(Long id);

    List<Cita> findAllByAveria(Averia averia);

    //List<Cita> findAllByTipoAveria(TipoAveria tipoAveria);


    Object findAllByTaller(Taller taller);
}