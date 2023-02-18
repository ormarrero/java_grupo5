package com.example.service;

import com.example.entities.Taller;
import com.example.repositories.TallerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TallerServiceImpl implements TallerService {

    private final TallerRepository tallerRepository;

    @Override
    public List<Taller> findAll() {

        return tallerRepository.findAll();
    }

    public Optional<Taller> findById(Long id) {

        return tallerRepository.findById(id);
    }
    public List<Taller> findAllByNombre(String nombre) {

        return  tallerRepository.findAllByNombre(nombre);
    }
    public List<Taller> findAllByTelefono(Integer telefono) {

        return tallerRepository.findAllByTelefono(telefono);
    }
    public List<Taller> findAllByNombreAndTelefono(String nombre, Integer telefono) {

        return tallerRepository.findAllByNombreAndTelefono(nombre, telefono);
    }
    public Taller save(Taller taller) {

        return tallerRepository.save(taller);
    }
    public void deleteById(Long id) {

        tallerRepository.deleteById(id);
    }
}
