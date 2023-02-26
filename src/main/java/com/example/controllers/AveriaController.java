package com.example.controllers;

import com.example.entities.Averia;
import com.example.entities.enums.Grado;
import com.example.entities.enums.TipoAveria;
import com.example.service.AveriaService;
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
public class AveriaController {
    private final AveriaService averiaService;

  /*  @GetMapping("/")
    public String index() {
        return "redirect:/averias";
    }*/

    @GetMapping("averias") // GET http://localhost:8080/averias
    public String findAll(Model model) {
        List<Averia> averias = averiaService.findAll();
        model.addAttribute("averias", averias);
        return "averia/averia-list";
    }

    @GetMapping("averias/{id}") // http://localhost:8080/averias/1
    public String findById(Model model, @PathVariable Long id) {
        Optional<Averia> averiaOptional = averiaService.findById(id);
        if (averiaOptional.isPresent())
            model.addAttribute("averia", averiaOptional.get());
        else
            model.addAttribute("error", "Averia not found");

        return "averia/averia-detail";
    }

    @GetMapping("averias/tipo/{tipoAveria}") // http://localhost:8080/averias/tipo/ELECTRICO
    public String findByTipo(Model model, @PathVariable TipoAveria tipoAveria){
        model.addAttribute("averias", averiaService.findAllByTipo(tipoAveria));
        return "averia/averia-list";
    }

    @GetMapping("averias/descripcion/{descripcion}") // http://localhost:8080/averias/descripcion/texto cualquiera
    public String findByDescripcion(Model model, @PathVariable String descripcion){
        model.addAttribute("averias", averiaService.findAllByDescripcion(descripcion));
        return "averia/averia-list";
    }

    @GetMapping("averias/fechaHora/{fechaHora}")
    public String findByFechaHora(Model model, @PathVariable LocalDateTime fechaHora){
        model.addAttribute("averias", averiaService.findAllByFechaHora(fechaHora));
        return "averia/averia-list";
    }

    @GetMapping("averias/grado/{grado}") // http://localhost:8080/averias/grado/MEDIO
    public String findByGrado(Model model, @PathVariable Grado grado){
        model.addAttribute("averias", averiaService.findAllByGrado(grado));
        return "averia/averia-list";
    }

    @GetMapping("averias/create")
    public String createForm(Model model) {
        Averia averia = new Averia();
        model.addAttribute("averia", averia);
        return "averia/averia-form";
    }

    @GetMapping("averias/{id}/edit")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Averia> averiaOptional = averiaService.findById(id);
        if (averiaOptional.isPresent()) {
            model.addAttribute("averia", averiaOptional.get());
        } else {
            model.addAttribute("error", "Averia not found");
        }

        return "averia/averia-form";
    }

    @PostMapping("averias") // POST http://localhost:8080/averias
    public String saveForm(@ModelAttribute Averia averia) {
        averiaService.save(averia);
        return "redirect:/averias"; // Redirección a GET /averias
    }

    @GetMapping("averias/{id}/delete")
    public String deleteById(@PathVariable Long id) {
        averiaService.deleteById(id);
        return "redirect:/averias";
    }
}
