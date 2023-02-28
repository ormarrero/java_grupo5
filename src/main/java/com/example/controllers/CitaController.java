package com.example.controllers;


import com.example.entities.*;


import com.example.service.CitaService;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class CitaController {

    private final CitaService citaService;

    // @GetMapping("/")
    // public String index() {
    //    return "redirect:/citas";
    // }

    // findAll - buscar todas las citas
    @GetMapping("citas")
    public String findAll(Model model) {
        List<Cita> citas = citaService.findAll();
        model.addAttribute("citas", citas);
        return "cita/cita-list";
    }

    // findById - buscar una cita por su id
    @GetMapping("citas/{id}")
    public String findById(Model model, Long id) {
        Optional<Cita> citaOptional = citaService.findById(id);

        if (citaOptional.isPresent()) {
            Cita cita = citaOptional.get();
            model.addAttribute("cita", cita);
            return "cita/cita-detail";

        } else {
            model.addAttribute("error", "Not found");
            return "cita/cita-detail";
        }

    }

    // findAllByCliente - buscar todas las citas por Id de cliente
    @GetMapping("citas/cliente/{id}")
    public String findAllByClienteId(Model model, Long id) {
        List<Cita> citas = citaService.findAllByClienteId(id);
        model.addAttribute("citas", citas);
        return "cita/cita-list";
    }
    //  BUSCAR CITA POR CLIENTE
    @GetMapping("citas/cliente/{cliente}") // http://localhost:8080/clientes
    public String findAllByCliente(Model model, @PathVariable Cliente cliente) {
        model.addAttribute("citas", citaService.findAllByCliente(cliente));

        return "cita/cita-list";
    }
    // BUSCAR POR FECHA HORA
    @GetMapping("citas/fechaHora/{fechaHora}") // http://localhost:8080/cita/fechaHora
    public String findAllByFechaHora(Model model, @PathVariable LocalDateTime fechaHora) {
        model.addAttribute("citas", citaService.findAllByFechaHora(fechaHora));

        return "cita/cita-list";
    }
    // BUSCAR POR AVERIA
    @GetMapping("citas/averia/{averia}") // http://localhost:8080/cita/averia
    public String findAllByAveria(Model model, @PathVariable Averia averia) {
        model.addAttribute("citas", citaService.findAllByAveria(averia));

        return "cita/cita-list";
    }

    // BUSCAR POR VEHICULO
    @GetMapping("citas/vehiculo/{vehiculo}") // http://localhost:8080/cita/vehiculo
    public String findAllByVehiculo(Model model, @PathVariable Vehiculo vehiculo) {
        model.addAttribute("citas", citaService.findAllByVehiculo(vehiculo));

        return "cita/cita-list";
    }
    // BUSCAR POR TALLER
    @GetMapping("citas/taller/{taller}") // http://localhost:8080/cita/taller
    public String findAllByTaller(Model model, @PathVariable Taller taller) {
        model.addAttribute("citas", citaService.findAllByTaller(taller));

        return "cita/cita-list";
    }




    // __________________________________________________________
    //  formulario para crear una nueva cita

    @GetMapping("citas/create")
    public String createForm(Model model) {
        Cita cita = new Cita();
        model.addAttribute("cita", cita); // objeto vacío para rellenar desde el formulario

        return "cita/cita-form";
    }

    //  formulario para editar una cita existente

    @GetMapping("{/citas/{id}/edit}")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Cita> citaOpt = citaService.findById(id);
        if (citaOpt.isPresent()) {
            model.addAttribute("cita", citaOpt.get());

        } else {
            model.addAttribute("error", "No hay citas");
        }

        return "cita/cita-form";
    }

    // guardar formulario (save)

    @PostMapping("citas") // POST http://localhost:8080/citas
    public String saveForm(@ModelAttribute Cita cita) {
        citaService.save(cita);
        return "redirect:/citas"; // Redirección a GET /cita
    }

    // deleteById

    @GetMapping("citas/{id}/delete")
    public String deleteById(@PathVariable Long id, Model model) {

        try {
            citaService.deleteById(id);
            return "redirect:/citas";
        } catch (EmptyResultDataAccessException e) {
            model.addAttribute("error", "No se puede borrar un elemento que no existe");
        }
        return "cita/cita-list";

    }




}

