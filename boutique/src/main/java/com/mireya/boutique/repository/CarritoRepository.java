package com.mireya.boutique.repository;

import com.mireya.boutique.model.Carrito;
import com.mireya.boutique.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {
     Optional<Carrito> findByCliente(Cliente cliente); //Para obtener el carrito por cliente.

}