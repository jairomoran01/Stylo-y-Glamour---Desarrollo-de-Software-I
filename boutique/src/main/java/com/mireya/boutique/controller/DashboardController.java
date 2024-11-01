package com.mireya.boutique.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;

@Controller

public class DashboardController {



    @GetMapping("/dashboard")
    public String mostrarDashboard(HttpSession session) {
        // Verificar si existe una sesión activa
        if (session.getAttribute("cliente") == null) {
            // Si no hay sesión, redirigir al login
            return "redirect:/login";
        }
        // Si hay sesión, mostrar el dashboard
        return "dashboard";
    }
}
