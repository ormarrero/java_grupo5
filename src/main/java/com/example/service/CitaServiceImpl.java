package com.example.service;


import com.example.entities.Cita;

import com.example.repositories.CitaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CitaServiceImpl implements CitaService{

    private final CitaRepository citaRepository;

    @Override
    public List<Cita> findAll() { return citaRepository.findAll();
    }

    @Override
    public Optional<Cita> findById(Long id) {
        return citaRepository.findById(id);
    }

    @Override
    public List<Cita> findAllByCalle(String calle) {
        return citaRepository.findAllByCalle(calle);
    }

    @Override
    public List<Cita> findAllByNumero(Integer numero) {
        return citaRepository.findAllByNumero(numero);
    }

    @Override
    public List<Cita> findAllByCalleAndNumero(String calle, Integer numero) {
        return citaRepository.findAllByCalleAndNumero(calle, numero);
    }

    @Override
    public List<Cita> findAllByCiudad(String ciudad) {
        return citaRepository.findAllByCiudad(ciudad);
    }

    @Override
    public List<Cita> findAllByCp(Integer cp) {
        return citaRepository.findAllByCp(cp);
    }

    @Override
    public List<Cita> findAllByCiudadAndCp(String ciudad, Integer cp) {
        return citaRepository.findAllByCiudadAndCp(ciudad, cp);
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

