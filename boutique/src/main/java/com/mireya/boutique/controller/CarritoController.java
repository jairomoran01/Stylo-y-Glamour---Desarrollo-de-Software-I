package com.mireya.boutique.controller;

import com.mireya.boutique.model.Carrito;
import com.mireya.boutique.model.Cliente;
import com.mireya.boutique.model.Producto;
import com.mireya.boutique.repository.CarritoRepository;
import com.mireya.boutique.repository.ProductoRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class CarritoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CarritoRepository carritoRepository;



    @PostMapping("/agregar-al-carrito")
    public String agregarAlCarrito(@RequestParam("productoId") Long productoId, HttpSession session) {
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        if (cliente == null) {
            return "redirect:/login"; // o a la página que corresponda
        }
         Optional<Carrito> carritoOptional = carritoRepository.findByCliente(cliente);
         Carrito carrito;

         if(carritoOptional.isPresent()){
            carrito = carritoOptional.get();

         } else {
               // Crear nuevo carrito si no existe para el cliente
               carrito = new Carrito();
               carrito.setCliente(cliente);
               carritoRepository.save(carrito);
         }

        Optional<Producto> productoOptional = productoRepository.findById(productoId);
        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            carrito.getProductos().add(producto); // Agregar el producto al carrito
            carrito.setTotal(carrito.getTotal()+ producto.getPrecio());
            carritoRepository.save(carrito);

        }



        return "redirect:/dashboard"; // Redirigir de nuevo al dashboard
    }



    @GetMapping("/ver-carrito")
    public String verCarrito(HttpSession session, Model model) {
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        if (cliente == null) {
            return "redirect:/login";
        }

        Optional<Carrito> carritoOptional = carritoRepository.findByCliente(cliente);
        if (carritoOptional.isPresent()) {
            Carrito carrito = carritoOptional.get();
            model.addAttribute("carrito", carrito);
        } else {
            model.addAttribute("carritoVacio", true); // Indicador para la vista
        }
        return "ver-carrito"; // Vista del carrito

    }
}
