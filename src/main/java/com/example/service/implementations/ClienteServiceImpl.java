package com.example.service.implementations;





import com.example.entities.Cliente;

import com.example.entities.Vehiculo;
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
    public List<Cliente> findAll() {
        return  clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Cliente> findAllByNombreCompleto(String nombreCompleto) {
        return clienteRepository.findAllByNombreCompleto( nombreCompleto);
    }

    @Override
    public List<Cliente> findAllByEmail(String email) {
        return clienteRepository.findAllByEmail(email);
    }

    @Override
    public List<Cliente> findAllByNif(String nif) {
        return clienteRepository.findAllByNif(nif);
    }

    @Override
    public List<Cliente> findAllByTelefono(Integer telefono) {
        return clienteRepository.findAllBytelefono(telefono);
    }

    @Override
    public List<Cliente> findAllByEmailAndNif(String email, String nif) {
        return clienteRepository.findAllByEmailAndNif(email, nif);
    }

    @Override
    public Object findAllByVehiculo(Vehiculo vehiculo) {
        return null;
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(Long id) {clienteRepository.deleteById(id); }

}

