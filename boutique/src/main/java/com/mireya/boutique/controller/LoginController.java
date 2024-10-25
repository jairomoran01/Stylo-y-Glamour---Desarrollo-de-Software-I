package com.mireya.boutique.controller;

import com.mireya.boutique.model.Cliente;
import com.mireya.boutique.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Mostrar el formulario de inicio de sesión
    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login";
    }

    // Procesar el formulario de inicio de sesión
    @PostMapping("/login")
    public String procesarLogin(@RequestParam("correo") String correo,
                                @RequestParam("contraseña") String contraseña,
                                Model model) {
        Cliente cliente = clienteRepository.findByCorreoAndContraseña(correo, contraseña);

        if (cliente != null) {
            // Iniciar sesión exitosa, redirige al dashboard o a otra página
            model.addAttribute("cliente", cliente);
            return "redirect:/dashboard";
        } else {
            // Iniciar sesión fallida, mostrar mensaje de error
            model.addAttribute("error", "Correo o contraseña incorrectos");
            return "login";
        }
    }
}
