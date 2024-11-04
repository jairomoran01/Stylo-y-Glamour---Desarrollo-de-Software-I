package com.mireya.boutique.repository;

import com.mireya.boutique.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Puedes agregar consultas personalizadas aquí si es necesario
    Cliente findByCorreoAndContraseña(String correo, String contraseña);
    Cliente findByCorreo(String correo);
}
