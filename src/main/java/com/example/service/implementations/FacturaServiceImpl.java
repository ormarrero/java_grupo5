package com.example.service.implementations;


import com.example.entities.Averia;
import com.example.entities.Cliente;
import com.example.entities.Factura;
import com.example.entities.Taller;
import com.example.repositories.FacturaRepository;
import com.example.service.FacturaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class FacturaServiceImpl implements FacturaService {
	
	private final FacturaRepository facturaRepository;
	
	@Override
	public List<Factura> findAll() { return facturaRepository.findAll();}
		
		@Override
		public Optional<Factura> findById(Long id) { return facturaRepository.findById(id);}
	
	@Override
	public List<Factura> findAllByMonto(Double monto) { return facturaRepository.findAllByMonto(monto);}

	@Override
	public List<Factura> findAllByCliente(Cliente cliente) {
		return facturaRepository.findAllByCliente(cliente);
	}

	@Override
	public List<Factura> findAllByTaller(Taller taller) {
		return facturaRepository.findAllByTaller(taller);
	}

	@Override
	public List<Factura> findAllByAveria(Averia averia) {
		return facturaRepository.findAllByAveria(averia);
	}

	@Override
	public List<Factura> findAllByClienteId(Long id) {
		return facturaRepository.findAllByClienteId(id);
	}

	@Override
	public List<Factura> findAllByTallerId(Long id) {
		return facturaRepository.findAllByTallerId(id);
	}

	@Override
	public List<Factura> findAllByAveriaId(Long id) {
		return facturaRepository.findAllByAveriaId(id);
	}


	@Override
		public Factura save(Factura factura){return facturaRepository.save(factura);}
		
		@Override
		public void deleteById(Long id){facturaRepository.deleteById(id);
		
		
		
	}
	}
