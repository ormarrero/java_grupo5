package com.example.service;

import com.example.entities.Averia;
import com.example.entities.Cliente;
import com.example.entities.Factura;
import com.example.entities.Taller;

import java.util.List;
import java.util.Optional;

public interface FacturaService {
	
		// crud
		List<Factura> findAll();
		Optional<Factura> findById(Long id);
		List<Factura> findAllByMonto(Double monto);
		List<Factura> findAllByCliente(Cliente cliente);
		List<Factura> findAllByTaller(Taller taller);
		List<Factura> findAllByAveria(Averia averia);
		List<Factura> findAllByClienteId(Long id);
		List<Factura> findAllByTallerId(Long id);
		List<Factura> findAllByAveriaId(Long id);
		Factura save(Factura factura);
		void deleteById(Long id);
	}