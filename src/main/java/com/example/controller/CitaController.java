package com.example.controller;

import com.example.entities.Averia;
import com.example.entities.Cita;
import com.example.entities.Cliente;
import com.example.service.CitaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class CitaController {

    private final CitaService citaService;

    @GetMapping("/")
    public String index() {
        return "redirect:/citas";
    }

    //  LISTA DE CLIENTES
    @GetMapping("cita/{cliente}") // GET http://localhost:8080/clientes
    public String findAllByCliente(Model model) {
        List<Cita> citas = citaService.findAll();
        model.addAttribute("clientes", citas);
        return "citas/cita-list";
    }
        //FECHA Y HORA
    @GetMapping("cita/{fechaHora}") // GET http://localhost:8080/fechayhora
    public String findAllByFechaHora(Model model) {
        List<Cita> citas = citaService.findAllByFechaHora();
        model.addAttribute("fechaHora", citas);
        return "citas/cita-list";
    }

    // AVERÍA
    @GetMapping("cita/{averia}") // GET http://localhost:8080/avería
    public Averia findAllByAveria(Model model) {
        List<Cita> citas = citaService.findAllByAveria(Averia averia);
        model.addAttribute("citas", citas);
        return "citas/cita-list";
    }
}
