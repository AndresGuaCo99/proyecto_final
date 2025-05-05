package com.example.proyecto_final.Repository;

import com.example.proyecto_final.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
