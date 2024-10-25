package com.mireya.boutique.controller;

import com.mireya.boutique.model.Cliente;
import com.mireya.boutique.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/registrar")
    public String registrarCliente(@ModelAttribute Cliente cliente) {
        // Guardar cliente en la base de datos
        clienteRepository.save(cliente);
        // Redirigir a la página de registro con un mensaje de éxito
        return "redirect:/registro?success";
    }
}
