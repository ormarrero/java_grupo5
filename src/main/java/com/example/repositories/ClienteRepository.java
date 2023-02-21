package com.example.repositories;

import com.example.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findAllByCalleAndNumero(String calle, Integer numero);

    List<Cliente> findAllByNumero(Integer numero);

    List<Cliente> findAllByCalle(String calle);

    List<Cliente> findAllByCiudad(String ciudad);

    List<Cliente> findAllByCp(Integer cp);

    List<Cliente> findAllByCiudadAndCp(String ciudad, Integer cp);
}