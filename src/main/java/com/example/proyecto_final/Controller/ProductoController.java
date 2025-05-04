package com.example.proyecto_final.Controller;


import com.example.proyecto_final.Model.Productos;
import com.example.proyecto_final.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*") // Permitir solicitudes desde otros dominios
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    @GetMapping
    public List<Productos> getAllProductos() {
        return productoRepository.findAll();
    }

    // Obtener producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Productos> getProductoById(@PathVariable Integer id) {
        Optional<Productos> producto = productoRepository.findById(id);
        return producto.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear nuevo producto
    @PostMapping
    public Productos createProducto(@RequestBody Productos productos) {
        return productoRepository.save(productos);
    }

    // Actualizar producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Productos> updateProducto(@PathVariable Integer id, @RequestBody Productos productoDetails) {
        Optional<Productos> optionalProducto = productoRepository.findById(id);

        if (optionalProducto.isPresent()) {
            Productos productos = optionalProducto.get();
            productos.setNombre(productoDetails.getNombre());
            productos.setDescripcion(productoDetails.getDescripcion());
            productos.setPrecio(productoDetails.getPrecio());
            productos.setCategoria(productoDetails.getCategoria());
            productos.setImagen(productoDetails.getImagen());
            productos.setStock(productoDetails.getStock());
            productos.setProveedor(productoDetails.getProveedor());

            return ResponseEntity.ok(productoRepository.save(productos));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Integer id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
