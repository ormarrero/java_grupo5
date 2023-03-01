package com.example.service.implementations;


import com.example.entities.Cita;

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
    public List<Cita> findAllByFechaHora(LocalDateTime fechaHora) {
        return citaRepository.findAllByFechaHora(fechaHora);
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