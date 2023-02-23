package com.example.controllers;

import com.example.entities.Address;
import com.example.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/")
    public String index() {
        return "redirect:/addresses";
    }

    @GetMapping("addresses") // GET http://localhost:8080/addresses
    public String findAll(Model model) {
        List<Address> addresses = addressService.findAll();
        model.addAttribute("addresses", addresses);
        return "address/address-list";
    }

    @GetMapping("addresses/{id}") // http://localhost:8080/addresses/1
    public String findById(Model model, @PathVariable Long id) {
        Optional<Address> addressOptional = addressService.findById(id);
        if (addressOptional.isPresent())
            model.addAttribute("address", addressOptional.get());
        else
            model.addAttribute("error", "Address not found");

        return "address/address-detail";
    }

    @GetMapping("addresses/calle/{calle}") // http://localhost:8080/addresses/calle/calle 9 d´Octubre
    public String findByCalle(Model model, @PathVariable String calle){
        model.addAttribute("addresses", addressService.findAllByCalle(calle));
        return "address/address-list";
    }

    @GetMapping("addresses/numero/{numero}") // http://localhost:8080/addresses/numero/52
    public String findByNumero(Model model, @PathVariable Integer numero){
        model.addAttribute("addresses", addressService.findAllByNumero(numero));
        return "address/address-list";
    }

    @GetMapping("addresses/calle/{calle}/numero/{numero}") // http://localhost:8080/addresses/calle/calle 9 d´Octubre/numero/52
    public String findByCalleAndNumero(Model model,
                                         @PathVariable String calle,
                                         @PathVariable Integer numero) {
        model.addAttribute("addresses", addressService.findAllByCalleAndNumero(calle, numero));
        return "address/address-list";
    }

    @GetMapping("addresses/ciudad/{ciudad}") // http://localhost:8080/addresses/ciudad/Valencia
    public String findByCiudad(Model model, @PathVariable String ciudad){
        model.addAttribute("addresses", addressService.findAllByCiudad(ciudad));
        return "address/address-list";
    }

    @GetMapping("addresses/cp/{cp}") // http://localhost:8080/addresses/cp/46910
    public String findByCp(Model model, @PathVariable Integer cp){
        model.addAttribute("addresses", addressService.findAllByCp(cp));
        return "address/address-list";
    }

    @GetMapping("addresses/ciudad/{ciudad}/cp/{cp}") // http://localhost:8080/addresses/ciudad/Valencia/cp/46910
    public String findByCiudadAndCp(Model model,
                                         @PathVariable String ciudad,
                                         @PathVariable Integer cp) {
        model.addAttribute("addresses", addressService.findAllByCiudadAndCp(ciudad, cp));
        return "address/address-list";
    }


    @GetMapping("addresses/create")
    public String createForm(Model model) {
        Address address = new Address();
        model.addAttribute("address", address);
        return "address/address-form";
    }

    @GetMapping("addresses/{id}/edit")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Address> addressOptional = addressService.findById(id);
        if (addressOptional.isPresent()) {
            model.addAttribute("address", addressOptional.get());
        } else {
            model.addAttribute("error", "Address not found");
        }

        return "address/address-form";
    }

    @PostMapping("addresses") // POST http://localhost:8080/addresses
    public String saveForm(@ModelAttribute Address address) {
        addressService.save(address);
        return "redirect:/addresses"; // Redirección a GET /addresses
    }

    @GetMapping("addresses/{id}/delete")
    public String deleteById(@PathVariable Long id) {
        addressService.deleteById(id);
        return "redirect:/addresses";
    }
}
