package com.example.service;


import com.example.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    // crud
    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    List<Cliente> findAllByCalle(String calle);
    List<Cliente> findAllByNumero(Integer numero);
    List<Cliente> findAllByCalleAndNumero(String calle, Integer numero);
    List<Cliente> findAllByCiudad(String ciudad);
    List<Cliente> findAllByCp(Integer cp);
    List<Cliente> findAllByCiudadAndCp(String ciudad, Integer cp);
    Cliente save(Cliente cliente);
    void deleteById(Long id);
}