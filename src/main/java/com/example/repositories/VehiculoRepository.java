package com.example.repositories;

import com.example.entities.enums.Combustible;
import com.example.entities.enums.TipoVehiculo;
import com.example.entities.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    List<Vehiculo> findAllByModelo(String modelo);
    List<Vehiculo> findAllByMarca(String marca);
    List<Vehiculo> findAllByModeloAndMarca(String modelo, String matricula);
    List<Vehiculo> findAllByMatricula(String matricula);
    List<Vehiculo> findAllByYear(Integer year);
}
