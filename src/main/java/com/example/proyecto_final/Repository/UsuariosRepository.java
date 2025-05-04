package com.example.proyecto_final.Repository;

import com.example.proyecto_final.Model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
    boolean existsByEmail(String email);
}
