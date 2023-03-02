package com.example.service;


import com.example.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    
    // crud
    List<Cliente> findAll();
    Optional<Cliente>findById(Long id);
    List<Cliente> findAllByNombreCompleto(String nombreCompleto);
    
    List<Cliente> findAllByEmail(String email);
    
    List<Cliente> findAllBynif(String nif);
    
    List<Cliente> findAllBytelefono(Integer telefono);
    
    List<Cliente> findAllByEmailAndNif(String email, String nif);
    
    Cliente save(Cliente cliente);
    void deleteById(Long id);
}