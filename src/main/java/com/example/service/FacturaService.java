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
		Factura save(Factura factura);
		void deleteById(Long id);
	}