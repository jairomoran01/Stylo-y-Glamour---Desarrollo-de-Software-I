package com.mireya.boutique.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
