package com.mireya.boutique.service;

import com.mireya.boutique.model.Producto;
import com.mireya.boutique.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public List<Producto> searchProductos(String nombre) {
        return productoRepository.findByNombreContaining(nombre);
    }

    public void guardarProducto(Producto producto) {
        productoRepository.save(producto);
    }
}
