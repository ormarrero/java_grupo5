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
import java.util.Optional;

@AllArgsConstructor
@Controller
public class CitaController {

    private final CitaService citaService;

    @GetMapping("/")
    public String index() {
        return "redirect:/citas";
    }

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

    // findAllByCliente - buscar todas las citas por id de cliente
    @GetMapping("citas/cliente/{id}")
    public String findAllByCliente(Model model, Long id) {
        List<Cita> citas = citaService.findAllByClienteId(id);
        model.addAttribute("citas", citas);
        return "cita/cita-list";
    }

    // obtener formulario para crear una nueva cita

    // obtener formulario para editar una cita existente

    // guardar formulario (save)

    // deleteById



//    //  LISTA DE CLIENTES
//    @GetMapping("cita/{cliente}") // GET http://localhost:8080/clientes
//    public String findAllByCliente(Model model) {
//        List<Cita> citas = citaService.findAll();
//        model.addAttribute("clientes", citas);
//        return "citas/cita-list";
//    }
//        //FECHA Y HORA
//    @GetMapping("cita/{fechaHora}") // GET http://localhost:8080/fechayhora
//    public String findAllByFechaHora(Model model) {
//        List<Cita> citas = citaService.findAllByFechaHora();
//        model.addAttribute("fechaHora", citas);
//        return "citas/cita-list";
//    }
//
//    // AVERÍA
//    @GetMapping("cita/{averiaId}") // GET http://localhost:8080/avería
//    public Averia findAllByAveria(Model model) {
//        List<Cita> citas = citaService.findAllByAveria(Averia averia);
//        model.addAttribute("citas", citas);
//        return "citas/cita-list";
//    }
}
