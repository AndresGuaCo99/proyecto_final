package com.example.proyecto_final.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PedidoDTO {

    private Integer pedidoId;
    private Integer usuarioId; // Solo el ID del usuario, para evitar ciclos infinitos
    private LocalDateTime fechaPedido;
    private BigDecimal total;
    private String estado;
    private String direccionEnvio;
    private String metodoPago;
}
