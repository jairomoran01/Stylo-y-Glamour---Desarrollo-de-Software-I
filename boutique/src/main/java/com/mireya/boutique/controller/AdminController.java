package com.mireya.boutique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mireya.boutique.model.Producto;
import com.mireya.boutique.service.ProductoService;

import org.springframework.ui.Model;
import java.util.List;
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

    @Autowired
    private ProductoService productoService;

    @GetMapping("/admin/productos/modificar")
    public String mostrarFormularioModificarProductos(Model model) {
        // Obtener todos los productos de la base de datos
        List<Producto> productos = productoService.findAll(); // Make sure you have the productoService injected
        model.addAttribute("productos", productos);
        return "admin-modificar-productos"; // This will be the new view to display
    }
}
