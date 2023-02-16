package com.example.service;

import com.example.entities.Mecanico;
import com.example.repositories.MecanicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MecanicoServiceImpl implements MecanicoService {

    private final MecanicoRepository mecanicoRepository;

    @Override
    public List<Mecanico> findAll() {

        return mecanicoRepository.findAll();
    }
}
