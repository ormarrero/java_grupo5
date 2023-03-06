package com.example.service;


import com.example.entities.Address;
import com.example.entities.Cliente;
import com.example.entities.Vehiculo;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    
    // crud
    List<Cliente> findAll();
    Optional<Cliente>findById(Long id);
    List<Cliente> findAllByNombreCompleto(String nombreCompleto);

    List<Cliente> findAllByAddress(Address address);
    
    List<Cliente> findAllByEmail(String email);
    
    List<Cliente> findAllByNif(String nif);
    
    List<Cliente> findAllByTelefono(Integer telefono);
    
    List<Cliente> findAllByEmailAndNif(String email, String nif);

    List<Cliente> findAllByVehiculo(Vehiculo vehiculo);
    
    Cliente save(Cliente cliente);
    void deleteById(Long id);
}