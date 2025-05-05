package com.example.proyecto_final.Service;

import com.example.proyecto_final.Model.Producto;
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
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    // Obtener un producto por ID
    public Optional<Producto> getProductoById(Integer id) {
        return productoRepository.findById(id);
    }
}
