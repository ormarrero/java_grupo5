package com.example.repositories;

import com.example.entities.Address;
import com.example.entities.Cliente;
import com.example.entities.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findAllByNombreCompleto(String nombreCompleto);
    List<Cliente> findAllByAddress(Address address);
    List<Cliente> findAllByEmail(String email);
    List<Cliente> findAllBynif(String nif);
    List<Cliente> findAllBytelefono(Integer telefono);
    List<Cliente> findAllByEmailAndNif(String email, String nif);
    List<Cliente> findAllByVehiculo(Vehiculo vehiculo);
}