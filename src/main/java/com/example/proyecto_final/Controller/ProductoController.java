package com.example.proyecto_final.Controller;

import com.example.proyecto_final.Dto.ProductoDTO;
import com.example.proyecto_final.Model.Categoria;
import com.example.proyecto_final.Model.Producto;
import com.example.proyecto_final.Repository.CategoriaRepository;
import com.example.proyecto_final.Repository.ProductoRepository;
import com.example.proyecto_final.Repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Obtener todos los productos
    @GetMapping
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    // Obtener producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Integer id) {
        return productoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear nuevo producto usando DTO
    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody ProductoDTO dto) {
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(dto.getCategoriaId());
        if (categoriaOpt.isEmpty()) {
            return ResponseEntity.badRequest().build(); // Categoría inválida
        }

        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setCategoria(categoriaOpt.get());
        producto.setImagen(dto.getImagen());
        producto.setStock(dto.getStock());
        //producto.setProveedor(dto.getProveedor());

        return ResponseEntity.ok(productoRepository.save(producto));
    }

    // Actualizar producto
    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Integer id, @RequestBody ProductoDTO dto) {
        Optional<Producto> optionalProducto = productoRepository.findById(id);
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(dto.getCategoriaId());

        if (optionalProducto.isPresent() && categoriaOpt.isPresent()) {
            Producto producto = optionalProducto.get();
            producto.setNombre(dto.getNombre());
            producto.setDescripcion(dto.getDescripcion());
            producto.setPrecio(dto.getPrecio());
            producto.setCategoria(categoriaOpt.get());
            producto.setImagen(dto.getImagen());
            producto.setStock(dto.getStock());

            return ResponseEntity.ok(productoRepository.save(producto));
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