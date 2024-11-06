package com.mireya.boutique.service;

import com.mireya.boutique.model.Producto;
import com.mireya.boutique.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    public List<Producto> findAll() {  // Add this method
        return productoRepository.findAll();
    }

    public Optional<Producto> findById(Long id) { // Useful to get a single product
        return productoRepository.findById(id);
    }

    public void updateProduct(Producto product) { // Add update method
      productoRepository.save(product);
    }
}
