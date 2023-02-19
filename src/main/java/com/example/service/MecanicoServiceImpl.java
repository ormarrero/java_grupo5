package com.example.service;

import com.example.entities.Mecanico;
import com.example.repositories.MecanicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MecanicoServiceImpl implements MecanicoService {

    private final MecanicoRepository mecanicoRepository;


    @Override
    public List<Mecanico> findAll() {

        return mecanicoRepository.findAll();
    }

    @Override
    public Optional<Mecanico> findById(Long id) {

        return mecanicoRepository.findById(id);
    }

    @Override
    public List<Mecanico> findAllByFullname(String fullname) {

        return mecanicoRepository.findAllByFullname(fullname);
    }

    @Override
    public List<Mecanico> findAllByTelefono(Integer telefono) {

        return mecanicoRepository.findAllByTelefono(telefono);
    }

    @Override
    public List<Mecanico> findAllByFullnameAndTelefono(String fullname, Integer telefono) {

        return mecanicoRepository.findAllByFullnameAndTelefono(fullname, telefono);
    }

    @Override
    public Mecanico save(Mecanico mecanico) {

        return mecanicoRepository.save(mecanico);
    }

    @Override
    public void deleteById(Long id) {

        mecanicoRepository.deleteById(id);
    }
}
