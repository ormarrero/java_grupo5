package com.example.service.implementations;

import com.example.entities.Taller;
import com.example.entities.Cita;
import com.example.entities.Factura;
import com.example.entities.Mecanico;
import com.example.repositories.MecanicoRepository;
import com.example.repositories.TallerRepository;
import com.example.service.CitaService;
import com.example.service.FacturaService;
import com.example.service.MecanicoService;
import com.example.service.TallerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TallerServiceImpl implements TallerService {

    private final TallerRepository tallerRepository;
    private final CitaService citaService;
    private final FacturaService facturaService;
    private final MecanicoService mecanicoService;


    @Override
    public List<Taller> findAll() {

        return tallerRepository.findAll();
    }

    @Override
    public Optional<Taller> findById(Long id) {

        return tallerRepository.findById(id);
    }

    @Override
    public List<Taller> findAllByNombre(String nombre) {

        return  tallerRepository.findAllByNombre(nombre);
    }

    @Override
    public List<Taller> findAllByTelefono(Integer telefono) {

        return tallerRepository.findAllByTelefono(telefono);
    }

    @Override
    public List<Taller> findAllByNombreAndTelefono(String nombre, Integer telefono) {

        return tallerRepository.findAllByNombreAndTelefono(nombre, telefono);
    }

    @Override
    public Taller save(Taller taller) {

        return tallerRepository.save(taller);
    }

    @Override
    public List<Taller> findAllByAddressId(Long id) {
        return tallerRepository.findAllByAddressId(id);
    }

    @Override
    public void deleteById(Long id) {

        citaService.findAllByTallerId(id).forEach(cita -> {
            cita.setTaller(null);
            citaService.save(cita);
        });

        facturaService.findAllByTallerId(id).forEach(factura -> {
            factura.setTaller(null);
            facturaService.save(factura);
        });

        mecanicoService.findAllByTallerId(id).forEach(mecanico -> {
            mecanico.setTaller(null);
            mecanicoService.save(mecanico);
        });

        tallerRepository.deleteById(id);
    }


}