package com.example.service.implementations;





import com.example.entities.Address;
import com.example.entities.Cliente;

import com.example.entities.Vehiculo;
import com.example.entities.Factura;
import com.example.entities.Cita;
import com.example.repositories.ClienteRepository;
import com.example.service.CitaService;
import com.example.service.ClienteService;
import com.example.service.FacturaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;
    private final CitaService citaService;
    private final FacturaService facturaService;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll(); }
    
    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);  }
    
    @Override
    public List<Cliente> findAllByNombreCompleto(String nombreCompleto) {
        return clienteRepository.findAllByNombreCompleto(nombreCompleto);
    }

    @Override
    public List<Cliente> findAllByAddress(Address address) {
        return clienteRepository.findAllByAddress(address);
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
        return clienteRepository.findAllByTelefono(telefono);
    }
    
    @Override
    public List<Cliente> findAllByEmailAndNif(String email, String nif) {
        return clienteRepository.findAllByEmailAndNif(email, nif);
    }

    @Override
    public List<Cliente> findAllByVehiculo(Vehiculo vehiculo){
        return clienteRepository.findAllByVehiculo(vehiculo);
    }
    
    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    @Override
    public void deleteById(Long id) {

        citaService.findAllByClienteId(id).forEach(cita -> {
            cita.setCliente(null);
            citaService.save(cita);
        });

        facturaService.findAllByClienteId(id).forEach(factura -> {
            factura.setCliente(null);
            facturaService.save(factura);
        });

        clienteRepository.deleteById(id);
    }

    @Override
    public List<Cliente> findAllByAddressId(Long id) { return clienteRepository.findAllByAddressId(id); }
    @Override
    public List<Cliente> findAllByVehiculoId(Long id) {
        return clienteRepository.findAllByVehiculoId(id);
    }
}