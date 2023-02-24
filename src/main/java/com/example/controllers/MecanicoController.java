package com.example.controllers;

import com.example.entities.Mecanico;
import com.example.service.MecanicoService;
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
public class MecanicoController {

    private final MecanicoService mecanicoService;

   // @GetMapping("/")
   // public String index() {
   //     return "redirect:/mecanicos";
   // }

    @GetMapping("mecanicos")
    public String findAll(Model model) {
        List<Mecanico> mecanicos = mecanicoService.findAll();
        model.addAttribute("mecanicos", mecanicos);
        return "mecanico/mecanico-list";

    }

    @GetMapping("mecanicos/{id}")
    public String findById(Model model, @PathVariable Long id) {
        Optional<Mecanico> mecanicoOptional = mecanicoService.findById(id);
        if (mecanicoOptional.isPresent())
            model.addAttribute("mecanico", mecanicoOptional.get());
        else
            model.addAttribute("error", "Mecanico not found");

        return "mecanico/mecanico-detail";

    }

    @GetMapping("mecanicos/fullname/{fullname}")
    public String findByFullname(Model model, @PathVariable String fullname) {
        model.addAttribute("mecanicos",mecanicoService.findAllByFullname(fullname));
        return "mecanico/mecanico-list";

    }

    @GetMapping("mecanicos/telefono/{telefono}")
    public String findByTelefono(Model model, @PathVariable Integer telefono) {
        model.addAttribute("mecanicos",mecanicoService.findAllByTelefono(telefono));
        return "mecanico/mecanico-list";

    }

    @GetMapping("mecanicos/fullname/{fullname}/telefono/{telefono}")
    public String findByFullnameAndTelefono(Model model, @PathVariable String fullname,
                                          @PathVariable Integer telefono) {
        model.addAttribute("mecanicos",mecanicoService.findAllByFullnameAndTelefono(fullname, telefono));
        return "mecanico/mecanico-list";

    }

    @GetMapping("mecanicos/create")
    public String createForm(Model model) {
        Mecanico mecanico = new Mecanico();
        model.addAttribute("mecanico", mecanico);
        return "mecanico/mecanico-form";

    }

    @GetMapping("mecanicos/{id}/edit")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Mecanico> mecanicoOptional = mecanicoService.findById(id);
        if (mecanicoOptional.isPresent()) {
            model.addAttribute("mecanico", mecanicoOptional.get());
        }
        else {
            model.addAttribute("error", "Mecanico not found");
        }

        return "mecanico/mecanico-form";
    }

    @PostMapping("mecanicos")
    public String saveForm(@ModelAttribute Mecanico mecanico) {
        mecanicoService.save(mecanico);
        return "redirect:/mecanicos";

    }

    @GetMapping("mecanicos/{id}/delete")
    public String deleteById(@PathVariable Long id) {
        mecanicoService.deleteById(id);
        return "redirect:/mecanicos";
    }
}
