package com.mireya.boutique.controller;

import com.mireya.boutique.model.Producto;
import com.mireya.boutique.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/nuevo")
    public String mostrarFormularioAgregarProducto(Model model) {
        model.addAttribute("producto", new Producto());
        return "admin-agregar-producto";
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoService.guardarProducto(producto);
        return "redirect:/admin";
    }
}
