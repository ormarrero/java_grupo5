package com.example.service;

import com.example.entities.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

        // crud
        List<Address> findAll();
        Optional<Address> findById(Long id);
        List<Address> findAllByCalle(String calle);
        List<Address> findAllByNumero(Integer numero);
        List<Address> findAllByCalleAndNumero(String calle, Integer numero);
        List<Address> findAllByCiudad(String ciudad);
        List<Address> findAllByCp(Integer cp);
        List<Address> findAllByCiudadAndCp(String ciudad, Integer cp);
        Address save(Address address);
        void deleteById(Long id);
}
