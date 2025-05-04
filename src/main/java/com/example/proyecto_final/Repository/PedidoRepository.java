package com.example.proyecto_final.Repository;

import com.example.proyecto_final.Model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
