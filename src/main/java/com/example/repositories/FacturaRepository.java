package com.example.repositories;

import com.example.entities.Averia;
import com.example.entities.Cliente;
import com.example.entities.Factura;
import com.example.entities.Taller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
	
	List<Factura> findAllByMonto(Double monto);
	List<Factura> findAllByCliente(Cliente cliente);
	List<Factura> findAllByTaller(Taller taller);
	List<Factura> findAllByAveria(Averia averia);

}
