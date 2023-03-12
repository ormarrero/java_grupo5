package com.example.controllers;

import com.example.entities.Taller;
import com.example.service.AddressService;
import com.example.service.TallerService;
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
public class TallerController {

    private final TallerService tallerService;
    private final AddressService addressService;

  //  @GetMapping("/")
  //  public String index() {
  //      return "redirect:/talleres";
  //  }


    @GetMapping("talleres")
    public String findAll(Model model) {
        List<Taller> talleres = tallerService.findAll();
        model.addAttribute("talleres", talleres);
        return "taller/taller-list";

    }

    @GetMapping("talleres/{id}")
    public String findById(Model model, @PathVariable Long id) {
        Optional<Taller> tallerOptional = tallerService.findById(id);
        if (tallerOptional.isPresent())
        {
            model.addAttribute("taller", tallerOptional.get());
            model.addAttribute("addresses", tallerOptional.get().getAddress());
        }
        else
            model.addAttribute("error", "Taller not found");

        return "taller/taller-detail";

    }

    @GetMapping("talleres/nombre/{nombre}")
    public String findByNombre(Model model, @PathVariable String nombre) {
        model.addAttribute("talleres",tallerService.findAllByNombre(nombre));
        return "taller/taller-list";

    }

    @GetMapping("talleres/telefono/{telefono}")
    public String findByTelefono(Model model, @PathVariable Integer telefono) {
        model.addAttribute("talleres",tallerService.findAllByTelefono(telefono));
        return "taller/taller-list";

    }

    @GetMapping("talleres/nombre/{nombre}/telefono/{telefono}")
    public String findByNombreAndTelefono(Model model, @PathVariable String nombre,
                                          @PathVariable Integer telefono) {
        model.addAttribute("talleres",tallerService.findAllByNombreAndTelefono(nombre, telefono));
        return "taller/taller-list";

    }

    @GetMapping("talleres/create")
    public String createForm(Model model) {
        Taller taller = new Taller();
        model.addAttribute("taller", taller);
        model.addAttribute("addresses", addressService.findAll());
        return "taller/taller-form";

    }

    @GetMapping("talleres/{id}/edit")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Taller> tallerOptional = tallerService.findById(id);
        if (tallerOptional.isPresent()) {
            model.addAttribute("taller", tallerOptional.get());
            model.addAttribute("address", tallerOptional.get().getAddress());
            model.addAttribute("addresses", addressService.findAll());
        }
        else {
            model.addAttribute("error", "Taller not found");
        }

        return "taller/taller-form";
    }

    @PostMapping("talleres")
    public String saveForm(@ModelAttribute Taller taller) {
        tallerService.save(taller);
        return "redirect:/talleres";

    }

    @GetMapping("talleres/{id}/delete")
    public String deleteById(@PathVariable Long id) {
        tallerService.deleteById(id);
        return "redirect:/talleres";
    }



}
