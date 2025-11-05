package com.example.API_REACT.service;

import com.example.API_REACT.model.Producto; // Importa la entidad Producto
import com.example.API_REACT.repository.ProductoRepository; // Importa el repositorio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Marca esta clase como un Service de Spring
public class ProductoService {

    // Inyección de dependencias para usar el repositorio
    @Autowired
    private ProductoRepository productoRepository;

    // Método para obtener todos los productos
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    // Método para guardar un nuevo producto o actualizar uno existente
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Método para obtener un producto por su ID
    public Producto obtenerPorId(Long id) {
        // findById devuelve un Optional, usamos orElse(null) para devolver el objeto o null si no existe
        return productoRepository.findById(id).orElse(null);
    }

    // Método para eliminar un producto por su ID
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
