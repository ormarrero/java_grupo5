package com.example.repositories;

import com.example.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAllByCalle(String calle);

    List<Address> findAllByNumero(Integer numero);

    List<Address> findAllByCalleAndNumero(String calle, Integer numero);

    List<Address> findAllByCiudad(String ciudad);

    List<Address> findAllByCp(Integer cp);

    List<Address> findAllByCiudadAndCp(String ciudad, Integer cp);
}