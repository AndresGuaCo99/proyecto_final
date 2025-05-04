package com.example.proyecto_final.Service;

import com.example.proyecto_final.Model.Usuarios;
import com.example.proyecto_final.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuariosService {
    @Autowired
    private UsuariosRepository usuariosRepository;

    // Crear o actualizar un usuario
    public Usuarios guardarUsuario(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

    // Obtener todos los usuarios
    public List<Usuarios> obtenerTodos() {
        return usuariosRepository.findAll();
    }

    // Obtener un usuario por ID
    public Optional<Usuarios> obtenerPorId(Integer id) {
        return usuariosRepository.findById(id);
    }

    // Eliminar un usuario por ID
    public void eliminarUsuario(Integer id) {
        usuariosRepository.deleteById(id);
    }
    public boolean existeEmail(String email) {
        return usuariosRepository.existsByEmail(email);
    }
}
