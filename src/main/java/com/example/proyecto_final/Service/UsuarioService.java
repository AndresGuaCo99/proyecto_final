package com.example.proyecto_final.Service;

import com.example.proyecto_final.Model.Usuario;
import com.example.proyecto_final.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service


public class UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    // Crear o actualizar un usuario
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Obtener todos los usuarios
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por ID
    public Optional<Usuario> obtenerPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    // Eliminar un usuario por ID
    public void eliminarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }
    public boolean existeEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }
}