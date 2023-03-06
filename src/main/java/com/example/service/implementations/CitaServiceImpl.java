package com.example.service.implementations;


import com.example.entities.*;

import com.example.entities.enums.TipoAveria;
import com.example.repositories.CitaRepository;
import com.example.service.CitaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;


    @Override
    public List<Cita> findAll() {
        return citaRepository.findAll();
    }

    @Override
    public Optional<Cita> findById(Long id) {
        return citaRepository.findById(id);
    }

    @Override
    public List<Cita> findAllByClienteId(Long id) {
        return citaRepository.findByClienteId(id);
    }

    /*@Override
    public List<Cita> findAllByTipoAveria(TipoAveria tipoAveria) {
        return citaRepository.findAllByTipoAveria(tipoAveria);
    }*/

    @Override
    public List<Cita> findAllByFechaHora(LocalDateTime fechaHora) {
        return citaRepository.findAllByFechaHora(fechaHora);
    }

    @Override
    public Object findAllByCliente(Cliente cliente) {
        return citaRepository.findAllByCliente(cliente);
    }

    @Override
    public Object findAllByVehiculo(Vehiculo vehiculo) {
        return citaRepository.findAllByVehiculo(vehiculo);
    }

    @Override
    public List<Cita> findAllByAveria(Averia averia) {
        return citaRepository.findAllByAveria(averia);
    }



    @Override
    public Object findAllByTaller(Taller taller) {
        return citaRepository.findAllByTaller(taller);
    }


    @Override
    public Cita save(Cita cita) {
        return citaRepository.save(cita);
    }

    @Override
    public void deleteById(Long id) {
        citaRepository.deleteById(id);
    }


}

