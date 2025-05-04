package com.example.proyecto_final.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carrito_id")
    private Integer carritoId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Productos productos;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(name = "fecha_agregado")
    private LocalDateTime fechaAgregado;

}
