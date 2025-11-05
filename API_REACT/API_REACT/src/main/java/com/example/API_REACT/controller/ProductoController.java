package com.example.API_REACT.controller;

import com.example.API_REACT.model.Producto; // Asegúrate de tener este import
import com.example.API_REACT.service.ProductoService; // Asegúrate de tener este import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// Importante para permitir la comunicación entre React (frontend) y Spring (backend)
@CrossOrigin(origins = "*") // Permite peticiones desde cualquier origen (ajustar en producción)
@RestController
@RequestMapping("/api/productos") // URL base para todos los endpoints de productos
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // 1. READ (Listar todos los productos)
    // Mapea a: GET /api/productos
    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.obtenerTodos();
    }

    // 2. CREATE (Crear un nuevo producto)
    // Mapea a: POST /api/productos
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }

    // 3. READ (Obtener producto por ID)
    // Mapea a: GET /api/productos/{id}
    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable Long id) {
        return productoService.obtenerPorId(id);
    }
    
    // **Nota: PUT para actualizar no está en la imagen, pero es la implementación estándar**
    // 4. UPDATE (Actualizar un producto)
    // Mapea a: PUT /api/productos/{id}
    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        // En una implementación robusta se verificaría si existe primero, pero para el ejemplo simple:
        producto.setId(id); // Asegura que el ID de la entidad a guardar es el del path
        return productoService.guardarProducto(producto);
    }

    // 5. DELETE (Eliminar un producto)
    // Mapea a: DELETE /api/productos/{id}
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }
}