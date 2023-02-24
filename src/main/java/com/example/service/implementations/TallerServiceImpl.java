package com.example.service.implementations;

import com.example.entities.Taller;
import com.example.repositories.MecanicoRepository;
import com.example.repositories.TallerRepository;
import com.example.service.TallerService;
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

    @Override
    public Optional<Taller> findById(Long id) {

        return tallerRepository.findById(id);
    }

    @Override
    public List<Taller> findAllByNombre(String nombre) {

        return  tallerRepository.findAllByNombre(nombre);
    }

    @Override
    public List<Taller> findAllByTelefono(Integer telefono) {

        return tallerRepository.findAllByTelefono(telefono);
    }

    @Override
    public List<Taller> findAllByNombreAndTelefono(String nombre, Integer telefono) {

        return tallerRepository.findAllByNombreAndTelefono(nombre, telefono);
    }

    @Override
    public Taller save(Taller taller) {

        return tallerRepository.save(taller);
    }

    @Override
    public void deleteById(Long id) {

        tallerRepository.deleteById(id);
    }
}