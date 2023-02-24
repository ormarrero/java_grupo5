package com.example.controllers;


import com.example.entities.Vehiculo;

import com.example.service.VehiculoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class VehiculoController {
    private final VehiculoService vehiculoService;

//    @GetMapping("/")
//    public String index() {
//        return "redirect:/vehiculos";
//    }

    @GetMapping("vehiculos") // GET http://localhost:8080/vehiculos
    public String findAll(Model model) {
        List<Vehiculo> vehiculos = vehiculoService.findAll();
        model.addAttribute("vehiculos", vehiculos);
        return "vehiculo/vehiculo-list";
    }

    @GetMapping("vehiculos/{id}") // http://localhost:8080/vehiculos/1
    public String findById(Model model, @PathVariable Long id) {
        Optional<Vehiculo> addressOptional = vehiculoService.findById(id);
        if (addressOptional.isPresent())
            model.addAttribute("vehiculo", addressOptional.get());
        else
            model.addAttribute("error", "Address not found");

        return "vehiculo/vehiculo-detail";
    }

    @GetMapping("vehiculos/modelo/{modelo}") // http://localhost:8080/vehiculos/modelo/BZ4X
    public String findByModelo(Model model, @PathVariable String modelo){
        model.addAttribute("vehiculos", vehiculoService.findAllByModelo(modelo));
        return "vehiculo/vehiculo-list";
    }

    @GetMapping("vehiculos/marca/{marca}") // http://localhost:8080/vehiculos/marca/Toyota
    public String findByMarca(Model model, @PathVariable String marca){
        model.addAttribute("vehiculos", vehiculoService.findAllByMarca(marca));
        return "vehiculo/vehiculo-list";
    }

    /**
     * OJO
     */
    @GetMapping("vehiculos/modelo/{modelo}/marca/{marca}") // http://localhost:8080/vehiculos/modelo/BZ4X/marca/Toyota
    public String findByModeloAndMarca(Model model,
                                       @PathVariable String modelo,
                                       @PathVariable String marca) {
        model.addAttribute("vehiculos", vehiculoService.findAllByModeloAndMarca(modelo, marca));
        return "vehiculo/vehiculo-list";
    }

    @GetMapping("vehiculos/matricula/{matricula}") // http://localhost:8080/vehiculos/matricula/asd123
    public String findByMatricula(Model model, @PathVariable String matricula){
        model.addAttribute("vehiculos", vehiculoService.findAllByMatricula(matricula));
        return "vehiculo/vehiculo-list";
    }

    @GetMapping("vehiculos/year/{year}") // http://localhost:8080/vehiculos/year/2021
    public String findByYear(Model model, @PathVariable Integer year){
        model.addAttribute("vehiculos", vehiculoService.findAllByYear(year));
        return "vehiculo/vehiculo-list";
    }


    @GetMapping("vehiculos/create") // http://localhost:8080/vehiculos/create
    public String createForm(Model model) {
        Vehiculo vehiculo = new Vehiculo();
        model.addAttribute("vehiculo", vehiculo);
        return "vehiculo/vehiculo-form";
    }

    @GetMapping("vehiculos/{id}/edit")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Vehiculo> vehiculoOptional = vehiculoService.findById(id);
        if (vehiculoOptional.isPresent()) {
            model.addAttribute("address", vehiculoOptional.get());
        } else {
            model.addAttribute("error", "Vehiculo not found");
        }

        return "vehiculo/vehiculo-form";
    }

    @PostMapping("vehiculos") // POST http://localhost:8080/vehiculos
    public String saveForm(@ModelAttribute Vehiculo vehiculo) {
        vehiculoService.save(vehiculo);
        return "redirect:/vehiculos"; // Redirección a GET /addresses
    }

    @GetMapping("vehiculos/{id}/delete")
    public String deleteById(@PathVariable Long id) {
        vehiculoService.deleteById(id);
        return "redirect:/vehiculos";
    }
}

