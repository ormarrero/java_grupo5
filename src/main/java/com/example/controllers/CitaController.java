package com.example.controllers;

import com.example.entities.Cita;
import com.example.entities.enums.TipoAveria;
import com.example.service.*;
import lombok.AllArgsConstructor;
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
    private final ClienteService clienteService;

    private final AveriaService averiaService;
    private final VehiculoService vehiculoService;
    private final TallerService tallerService;

    @GetMapping("/")
    public String index() {
        return "redirect:/citas";
    }


    @GetMapping("citas")
    public String findAll(Model model) {
        List<Cita> citas = citaService.findAll();
        model.addAttribute("citas", citas);
        return "cita/cita-list";

    }

    @GetMapping("citas/{id}")
    public String findById(Model model, @PathVariable Long id) {
        Optional<Cita> citaOptional = citaService.findById(id);
        if (citaOptional.isPresent())
        {
            model.addAttribute("cita", citaOptional.get());
            model.addAttribute("clientes", citaOptional.get().getCliente());
            model.addAttribute("averias", citaOptional.get().getAveria());
            model.addAttribute("vehiculos", citaOptional.get().getVehiculo());
            model.addAttribute("talleres", citaOptional.get().getTaller());
        }
        else
            model.addAttribute("error", "Cita not found");

        return "cita/cita-detail";

    }

    @GetMapping("citas/fechaHora/{fechaHora}")
    public String findByFechaHora(Model model, @PathVariable LocalDateTime fechaHora) {
        model.addAttribute("citas", citaService.findAllByFechaHora(fechaHora));
        return "cita/cita-list";

    }

    @GetMapping("citas/create")
    public String createForm(Model model) {
        Cita cita = new Cita();
        model.addAttribute("cita", cita);
        model.addAttribute("clientes", clienteService.findAll());
        model.addAttribute("averias", averiaService.findAll());
        model.addAttribute("vehiculos", vehiculoService.findAll());
        model.addAttribute("talleres", tallerService.findAll());

        return "cita/cita-form";

    }

    @GetMapping("citas/{id}/edit")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Cita> citaOptional = citaService.findById(id);
        if (citaOptional.isPresent()) {
            model.addAttribute("cita", citaOptional.get());

            model.addAttribute("cliente", citaOptional.get().getCliente());
            model.addAttribute("averia", citaOptional.get().getAveria());
            model.addAttribute("vehiculo", citaOptional.get().getVehiculo());
            model.addAttribute("taller", citaOptional.get().getTaller());

            model.addAttribute("clientes", clienteService.findAll());
            model.addAttribute("averias", averiaService.findAll());
            model.addAttribute("vehiculos", vehiculoService.findAll());
            model.addAttribute("talleres", tallerService.findAll());
        } else {
            model.addAttribute("error", "Cita not found");
        }

        return "cita/cita-form";
    }

    @PostMapping("citas")
    public String saveForm(@ModelAttribute Cita cita) {
        citaService.save(cita);
        return "redirect:/citas";

    }

    @GetMapping("citas/{id}/delete")
    public String deleteById(@PathVariable Long id) {
        citaService.deleteById(id);
        return "redirect:/citas";
    }


}

