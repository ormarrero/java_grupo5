package com.example.controllers;

import com.example.entities.Cliente;
import com.example.service.ClienteService;
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
public class ClienteController {

    private final ClienteService clienteService;

    //  @GetMapping("/")
    //  public String index() {
    //      return "redirect:/talleres";
    //  }


    @GetMapping("clientes")
    public String findAll(Model model) {
        List<Cliente> clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "cliente/cliente-list";

    }

    @GetMapping("clientes/{id}")
    public String findById(Model model, @PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        if (clienteOptional.isPresent())
            model.addAttribute("cliente", clienteOptional.get());
        else
            model.addAttribute("error", "Cliente not found");

        return "cliente/cliente-detail";

    }

    @GetMapping("clientes/nombreCompleto/{nombreCompleto}")
    public String findByNombreCompleto(Model model, @PathVariable String nombreCompleto) {
        model.addAttribute("clientes",clienteService.findAllByNombreCompleto(nombreCompleto));
        return "cliente/cliente-list";

    }

    @GetMapping("clientes/email/{email}")
    public String findByEmail(Model model, @PathVariable String email) {
        model.addAttribute("clientes",clienteService.findAllByEmail(email));
        return "cliente/cliente-list";

    }

    @GetMapping("clientes/nif/{nif}")
    public String findByNif(Model model, @PathVariable String nif) {
        model.addAttribute("clientes",clienteService.findAllByNif(nif));
        return "cliente/cliente-list";

    }

    @GetMapping("clientes/telefono/{telefono}")
    public String findByTelefono(Model model, @PathVariable Integer telefono) {
        model.addAttribute("talleres",clienteService.findAllByTelefono(telefono));
        return "cliente/cliente-list";

    }

    @GetMapping("clientes/email/{email}/nif/{nif}")
    public String findByEmailAndNif(Model model, @PathVariable String email,
                                    @PathVariable String nif) {
        model.addAttribute("clientes",clienteService.findAllByEmailAndNif(email, nif));
        return "taller/taller-list";

    }

    @GetMapping("clientes/create")
    public String createForm(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "cliente/cliente-form";

    }

    @GetMapping("clientes/{id}/edit")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        if (clienteOptional.isPresent()) {
            model.addAttribute("cliente", clienteOptional.get());
        }
        else {
            model.addAttribute("error", "Cliente not found");
        }

        return "cliente/cliente-form";
    }

    @PostMapping("clientes")
    public String saveForm(@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/clientes";

    }

    @GetMapping("clientes/{id}/delete")
    public String deleteById(@PathVariable Long id) {
        clienteService.deleteById(id);
        return "redirect:/clientes";
    }
























}