package com.mireya.boutique.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

    @GetMapping("/admin/login")
    public String mostrarFormularioLoginAdmin() {
        return "admin-login"; // Return the name of your admin login view
    }
    @GetMapping("/admin")
    public String adminDashboard() {
        return "admin-dashboard"; // Vista para administradores
    }

    @PostMapping("/admin/logout") // Nueva ruta para cerrar sesión
    public String logoutAdmin(HttpSession session) {
        // Aquí podrías realizar acciones adicionales de cierre de sesión si es necesario, 
        session.invalidate(); // Invalidate the session
        return "redirect:/admin//login?logout"; // Redirige al login de admin
    }
}
