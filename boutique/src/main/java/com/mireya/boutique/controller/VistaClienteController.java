package com.mireya.boutique.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistaClienteController {

    @GetMapping("/registro")
    public String mostrarFormularioRegistro() {
        return "registro";  // Devuelve la plantilla registro.html
    }
}
