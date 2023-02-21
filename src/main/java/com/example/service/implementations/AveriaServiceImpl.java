package com.example.service.implementations;

import com.example.entities.Averia;
import com.example.entities.enums.Grado;
import com.example.entities.enums.TipoAveria;
import com.example.repositories.AveriaRepository;
import com.example.service.AveriaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AveriaServiceImpl implements AveriaService {

    private final AveriaRepository averiaRepository;

    @Override
    public List<Averia> findAll() {
        return averiaRepository.findAll();
    }

    @Override
    public Optional<Averia> findById(Long id) {
        return averiaRepository.findById(id);
    }

    @Override
    public List<Averia> findAllByTipo(TipoAveria tipo) {
        return averiaRepository.findAllByTipo(tipo);
    }

    @Override
    public List<Averia> findAllByDescripcion(String descripcion) {
        return averiaRepository.findAllByDescripcion(descripcion);
    }

    @Override
    public List<Averia> findAllByFechaHora(LocalDateTime fecha_hora) {
        return averiaRepository.findAllByFechaHora(fecha_hora);
    }

    @Override
    public List<Averia> findAllByGrado(Grado grado) {
        return averiaRepository.findAllByGrado(grado);
    }

    @Override
    public Averia save(Averia averia) {
        return averiaRepository.save(averia);
    }

    @Override
    public void deleteById(Long id) {
        averiaRepository.deleteById(id);
    }
}
