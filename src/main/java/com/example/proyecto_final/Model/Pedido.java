package com.example.proyecto_final.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id")
    private Integer pedidoId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuarios usuario;

    @Column(name = "fecha_pedido")
    private LocalDateTime fechaPedido;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @Column(length = 50, nullable = false)
    private String estado;

    @Column(columnDefinition = "TEXT")
    private String direccionEnvio;

    @Column(name = "metodo_pago", length = 50)
    private String metodoPago;
}