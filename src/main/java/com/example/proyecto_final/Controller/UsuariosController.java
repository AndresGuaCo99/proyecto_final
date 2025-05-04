package com.example.proyecto_final.Controller;

import com.example.proyecto_final.Model.Usuarios;
import com.example.proyecto_final.Service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuariosController {
    @Autowired
    private UsuariosService usuariosService;

    @PostMapping
    public ResponseEntity<Usuarios> crearUsuario(@RequestBody Usuarios usuario) {
        if (usuariosService.existeEmail(usuario.getEmail())) {
            return ResponseEntity.badRequest().build(); // Email ya registrado
        }
        return ResponseEntity.ok(usuariosService.guardarUsuario(usuario));
    }

    // Obtener todos los usuarios
    @GetMapping
    public List<Usuarios> obtenerTodos() {
        return usuariosService.obtenerTodos();
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> obtenerPorId(@PathVariable Integer id) {
        Optional<Usuarios> usuario = usuariosService.obtenerPorId(id);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> actualizarUsuario(@PathVariable Integer id, @RequestBody Usuarios usuarioActualizado) {
        Optional<Usuarios> existente = usuariosService.obtenerPorId(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Usuarios usuario = existente.get();
        usuario.setNombre(usuarioActualizado.getNombre());
        usuario.setEmail(usuarioActualizado.getEmail());
        usuario.setContraseña(usuarioActualizado.getContraseña());
        usuario.setTelefono(usuarioActualizado.getTelefono());
        usuario.setFechaRegistro(usuarioActualizado.getFechaRegistro());
        usuario.setDireccion(usuarioActualizado.getDireccion());
        usuario.setPreferencias(usuarioActualizado.getPreferencias());

        return ResponseEntity.ok(usuariosService.guardarUsuario(usuario));
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id) {
        if (usuariosService.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        usuariosService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}