package com.mireya.boutique.controller;

import com.mireya.boutique.model.Producto;
import com.mireya.boutique.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

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

    @GetMapping("/modificar/{id}")
    public String mostrarFormularioModificarProducto(@PathVariable("id") Long id, Model model) {
        Optional<Producto> productoOptional = productoService.findById(id);
        if (productoOptional.isPresent()) {
            model.addAttribute("producto", productoOptional.get());
            return "admin-editar-producto"; // New view for editing a single product
    } else {
        // Handle product not found, e.g., redirect to error page or product list
        return "redirect:/admin/productos/modificar"; 
    }
    }

    @PostMapping("/modificar/{id}") //Updated method now takes an ID
    public String modificarProducto(@PathVariable("id") Long id, @ModelAttribute Producto producto) {
        producto.setId(id); // Ensure correct ID is saved
        productoService.updateProduct(producto); //Updates database record
        return "redirect:/admin/productos/modificar"; // redirect back to list page
    }
}
