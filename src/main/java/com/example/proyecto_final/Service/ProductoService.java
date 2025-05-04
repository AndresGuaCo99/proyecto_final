package com.example.proyecto_final.Service;

import com.example.proyecto_final.Model.Productos;
import com.example.proyecto_final.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    public List<Productos> getAllProductos() {
        return productoRepository.findAll();
    }

    // Obtener un producto por ID
    public Optional<Productos> getProductoById(Integer id) {
        return productoRepository.findById(id);
    }
}
