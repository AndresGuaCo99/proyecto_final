package com.example.proyecto_final.Controller;


import com.example.proyecto_final.Model.DetallePedido;
import com.example.proyecto_final.Service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detallePedidos")

public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping
    public ResponseEntity<List<DetallePedido>> getAllDetalles() {
        return new ResponseEntity<>(detallePedidoService.getAllDetalles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> getDetalleById(@PathVariable Integer id) {
        Optional<DetallePedido> detalle = detallePedidoService.getDetalleById(id);
        return detalle.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<DetallePedido> createDetalle(@RequestBody DetallePedido detalle) {
        DetallePedido nuevoDetalle = detallePedidoService.saveDetalle(detalle);
        return new ResponseEntity<>(nuevoDetalle, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallePedido> updateDetalle(@PathVariable Integer id, @RequestBody DetallePedido detalle) {
        Optional<DetallePedido> existing = detallePedidoService.getDetalleById(id);
        if (existing.isPresent()) {
            detalle.setDetalleId(id);
            DetallePedido actualizado = detallePedidoService.saveDetalle(detalle);
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalle(@PathVariable Integer id) {
        if (detallePedidoService.existsById(id)) {
            detallePedidoService.deleteDetalle(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
