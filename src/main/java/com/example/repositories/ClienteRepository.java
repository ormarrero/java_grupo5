package com.example.repositories;

import com.example.entities.Address;
import com.example.entities.Cita;
import com.example.entities.Cliente;
import com.example.entities.Vehiculo;
import com.example.entities.enums.TipoAveria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findAllByNombreCompleto(String nombreCompleto);
    List<Cliente> findAllByAddress(Address address);
    List<Cliente> findAllByEmail(String email);
    List<Cliente> findAllByNif(String nif);
    List<Cliente> findAllByTelefono(Integer telefono);
    List<Cliente> findAllByEmailAndNif(String email, String nif);
    List<Cliente> findAllByVehiculo(Vehiculo vehiculo);
}