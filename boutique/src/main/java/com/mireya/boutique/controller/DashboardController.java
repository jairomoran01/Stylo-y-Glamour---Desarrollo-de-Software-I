package com.mireya.boutique.controller;

import com.mireya.boutique.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/dashboard")
    public String mostrarDashboard(HttpSession session, Model model) {
        // Verificar si existe una sesión activa
        if (session.getAttribute("cliente") == null) {
            // Si no hay sesión, redirigir al login
            return "redirect:/login";
        }
        
        // Obtener todos los productos
        model.addAttribute("productos", productoService.getAllProductos());
        
        // Si hay sesión, mostrar el dashboard
        return "dashboard";
    }
}