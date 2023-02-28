package com.example.controllers;


import com.example.entities.Address;
import com.example.entities.Cliente;
import com.example.entities.Vehiculo;
import com.example.service.ClienteService;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
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
public class ClienteController {

    private final ClienteService clienteService;



   // @GetMapping("/")
   // public String index() {
    //    return "redirect:/clientes";
   // }

    //  LISTA DE CLIENTES
    @GetMapping("cliente") // GET http://localhost:8080/clientes
    public String findAll(Model model) {
        List<Cliente> clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "cliente/cliente-list";
    }
        // CREAR NUEVO CLIENTE
        // objeto vacío para rellenar desde el formulario
    @GetMapping("clientes/create") // http://localhost:8080/clientes/create
    public String createForm(Model model) {
        model.addAttribute("cliente", new Cliente());

        return "cliente/cliente-form";
    }
        // EDITAR CLIENTE
    @GetMapping("clientes/{id}/edit") // HTTP://localhost:8080/clientes/edit
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Cliente> clienteOpt = clienteService.findById(id);
        if (clienteOpt.isPresent()) {
            model.addAttribute("cliente", clienteOpt.get());
            model.addAttribute("cliente", clienteService.findAll());

        } else {
            model.addAttribute("error", "No existe cliente");
        }

        return "cliente/cliente-form";
    }
        // SAVE NEW CLIENTE
    @PostMapping("clientes") // POST http://localhost:8080/CLIENTES
    public String saveForm(@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/clientes"; // Redirección a GET /foods
    }


        // DELETE CLIENTE
        @GetMapping("clientes/{id}/delete")
        public String deleteById(@PathVariable Long id, Model model) {

            try {
                clienteService.deleteById(id);
                return "redirect:/cliente";

            } catch (EmptyResultDataAccessException e) {
                model.addAttribute("error", "No se puede borrar un cliente que no existe");
            }
            return "cita/cita-list";

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

    // BUSCAR POR NOMBRE COMPLETO
    @GetMapping("clientes/nombreCompleto")
    public String findAllByNombreCompleto(Model model, @PathVariable String nombreCompleto) {
        model.addAttribute("clientes",clienteService.findAllByNombreCompleto(nombreCompleto));

        return "cliente/cliente-list";
    }
        // BUSCAR POR ADDRESS
    @GetMapping("clientes/Address")
    public String findAllByAddress(Model model, @PathVariable Address Address) {
        model.addAttribute("cliente",clienteService.findAllByAddress(Address));

        return "cliente/cliente-list";
    }
    // BUSCAR POR EMAIL
    @GetMapping("clientes/email")
    public String findAllByEmail(Model model, @PathVariable String email) {
        model.addAttribute("clientes",clienteService.findAllByEmail(email));

        return "cliente/cliente-list";
    }

    // BUSCAR POR NIF

    @GetMapping("clientes/cliente/{nif}") // http://localhost:8080/clientes/nif
    public String findAllByNif(Model model, @PathVariable String nif) {
        model.addAttribute("clientes", clienteService.findAllByNif(nif));

        return "cliente/cliente-list";
    }


    // BUSCAR POR TELEFONO
    @GetMapping("clientes/telefono")
    public String findAllByTelefono(Model model, @PathVariable Integer telefono) {
        model.addAttribute("clientes",clienteService.findAllByTelefono(telefono));

        return "cliente/cliente-list";
    }


    // BUSCAR POR VEHICULO
    @GetMapping("clientes/vehiculo/{vehiculo}") // http://localhost:8080/vehiculos/vehiculo
    public String findAllByVehiculo(Model model, @PathVariable Vehiculo vehiculo) {
        model.addAttribute("clientes", clienteService.findAllByVehiculo(vehiculo));

        return "cliente/cliente-list";
    }

}