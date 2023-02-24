package com.example.controller;


import com.example.entities.Cliente;
import com.example.entities.Vehiculo;
import com.example.service.ClienteService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor

@Controller
public class ClienteController {

    private final ClienteService clienteService;



    @GetMapping("/")
    public String index() {
        return "redirect:/clientes";
    }

    //  LISTA DE CLIENTES
    @GetMapping("cliente") // GET http://localhost:8080/clientes
    public String findAll(Model model) {
        List<Cliente> clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "cliente/cliente-list";
    }

    //  BUSCAR POR ID
    @GetMapping("clientes/{id}") // http://localhost:8080/clientes/1
    public String findById(Model model, @PathVariable Long id) {
        Optional<Cliente> clienteOpt = clienteService.findById(id);
        if (clienteOpt.isPresent())
            model.addAttribute("cliente", clienteOpt.get());
        else
            model.addAttribute("error", "Cliente not found");

        return "cliente/cliente-detail";
    }

    // BUSCAR POR VEHICULO
    @GetMapping("clientes/vehiculo/{vehiculo}") // http://localhost:8080/vehiculos/vehiculo
    public String findAllByVehiculo(Model model, @PathVariable Vehiculo vehiculo) {
        model.addAttribute("clientes", clienteService.findAllByVehiculo(vehiculo));

        return "cliente/cliente-list";
    }





    // BUSCAR POR NIF

    @GetMapping("clientes/cliente/{nif}") // http://localhost:8080/clientes/nif
    public String findAllByNif(Model model, @PathVariable String nif) {
        model.addAttribute("clientes", clienteService.findAllByNif(nif));

        return "cliente/cliente-list";
    }
}