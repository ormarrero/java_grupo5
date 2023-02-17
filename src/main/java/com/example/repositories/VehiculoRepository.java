package com.example.repositories;

import com.example.entities.Combustible;
import com.example.entities.TipoVehiculo;
import com.example.entities.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    List<Vehiculo> findAllByModelo(String modelo);

    List<Vehiculo> findAllByMarca(String marca);

    List<Vehiculo> findAllByTipoVehículo(TipoVehiculo tipo);
    List<Vehiculo> findAllByMatricula(String matricula);
    List<Vehiculo> findAllByColor(String color);
    List<Vehiculo> findAllByCombustible(Combustible combustible);
    List<Vehiculo> findAllByYear(Integer year);

    List<Vehiculo> findAllModeloAndMarca(String modelo, String marca);
}
