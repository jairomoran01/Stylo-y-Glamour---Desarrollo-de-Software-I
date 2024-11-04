package com.mireya.boutique.controller;

import com.mireya.boutique.model.Cliente;
import com.mireya.boutique.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Mostrar el formulario de inicio de sesión
    @GetMapping({"/", "/login"})
    public String mostrarFormularioLogin() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalidate the session
        return "redirect:/login?logout"; // Redirect to the login page with a logout message
    }

    // Procesar el formulario de inicio de sesión
    @PostMapping("/login")

    public String procesarLogin(@RequestParam("correo") String correo,
                                @RequestParam("contraseña") String contraseña,
                                Model model,
                                HttpSession session) {
        Cliente cliente = clienteRepository.findByCorreoAndContraseña(correo, contraseña);
    
    
        if (cliente != null) {
            // Verifica la contraseña
            if (contraseña.equals(cliente.getContraseña())) {
                // Guardar el cliente en la sesión
                session.setAttribute("cliente", cliente);
                return "redirect:/dashboard";
            } else {
                model.addAttribute("error", "Correo o contraseña incorrectos");
            }
        } else {
            model.addAttribute("error", "No existe una cuenta con este correo");
        }
    
        return "login";
    }
}
