package com.example.API_REACT.repository;

import com.example.API_REACT.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Método customizado para buscar productos que contengan parte del nombre,
    // sin distinguir mayúsculas o minúsculas.
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
}
