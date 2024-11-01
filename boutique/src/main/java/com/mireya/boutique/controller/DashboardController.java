package com.mireya.boutique.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class DashboardController {


    @GetMapping("/dashboard")

    public String mostrarDashboard() {

        return "dashboard";  // Esto se refiere a dashboard.html

    }

}
