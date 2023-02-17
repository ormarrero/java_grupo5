package com.example.service;

import com.example.entities.Vehiculo;
import com.example.repositories.VehiculoRepository;

import java.util.List;
import java.util.Optional;

public class VehiculoServiceImpl implements VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoServiceImpl(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public List<Vehiculo> findAll() { return vehiculoRepository.findAll(); }

    @Override
    public Optional<Vehiculo> findById(Long id) {
        return vehiculoRepository.findById(id);
    }

    @Override
    public List<Vehiculo> findAllByModelo(String modelo) {
        return vehiculoRepository.findAllByModelo(modelo);
    }

    @Override
    public List<Vehiculo> findAllByMarca(String marca) {
        return vehiculoRepository.findAllByMarca(marca);
    }

    @Override
    public List<Vehiculo> findAllByModeloAndMarca(String modelo, String marca) {
        return vehiculoRepository.findAllModeloAndMarca(modelo, marca);
    }

    @Override
    public List<Vehiculo> findAllByMatricula(String matricula) {
        return vehiculoRepository.findAllByMatricula(matricula);
    }

    @Override
    public List<Vehiculo> findAllByColor(String color) {
        return vehiculoRepository.findAllByColor(color);
    }

    @Override
    public List<Vehiculo> findAllByYear(Integer year) {
        return vehiculoRepository.findAllByYear(year);
    }

    @Override
    public void deleteById(Long id) {vehiculoRepository.deleteById(id); }
}
