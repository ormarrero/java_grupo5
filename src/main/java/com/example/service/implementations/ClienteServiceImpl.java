package com.example.service.implementations;





import com.example.entities.Cliente;

import com.example.repositories.ClienteRepository;
import com.example.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {


    private final ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() { return clienteRepository.findAll(); }



    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> findAllByCalle(String calle) {
        return clienteRepository.findAllByCalle(calle);
    }

    @Override
    public List<Cliente> findAllByNumero(Integer numero) {
        return clienteRepository.findAllByNumero(numero);
    }

    @Override
    public List<Cliente> findAllByCalleAndNumero(String calle, Integer numero) {
        return clienteRepository.findAllByCalleAndNumero(calle, numero);
    }

    @Override
    public List<Cliente> findAllByCiudad(String ciudad) {
        return clienteRepository.findAllByCiudad(ciudad);
    }

    @Override
    public List<Cliente> findAllByCp(Integer cp) {
        return clienteRepository.findAllByCp(cp);
    }

    @Override
    public List<Cliente> findAllByCiudadAndCp(String ciudad, Integer cp) {
        return clienteRepository.findAllByCiudadAndCp(ciudad, cp);
    }



    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}

