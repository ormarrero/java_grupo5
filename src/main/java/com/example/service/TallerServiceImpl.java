package com.example.service;

import com.example.entities.Taller;
import com.example.repositories.TallerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TallerServiceImpl implements TallerService {

    private final TallerRepository tallerRepository;

    @Override
    public List<Taller> findAll() {

        return tallerRepository.findAll();
    }
}
