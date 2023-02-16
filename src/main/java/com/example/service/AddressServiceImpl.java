package com.example.service;

import com.example.entities.Address;
import com.example.repositories.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService{

    private final AddressRepository addressRepository;

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public List<Address> findAllByCalle(String calle) {
        return addressRepository.findAllByCalle(calle);
    }

    @Override
    public List<Address> findAllByNumero(Integer numero) {
        return addressRepository.findAllByNumero(numero);
    }

    @Override
    public List<Address> findAllByCalleAndNumero(String calle, Integer numero) {
        return addressRepository.findAllByCalleAndNumero(calle, numero);
    }

    @Override
    public List<Address> findAllByCiudad(String ciudad) {
        return addressRepository.findAllByCiudad(ciudad);
    }

    @Override
    public List<Address> findAllByCp(Integer cp) {
        return addressRepository.findAllByCp(cp);
    }

    @Override
    public List<Address> findAllByCiudadAndCp(String ciudad, Integer cp) {
        return addressRepository.findAllByCiudadAndCp(ciudad, cp);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }
}
