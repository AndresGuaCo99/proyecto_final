package com.example.proyecto_final.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proveedor_id")
    private Integer proveedorId;

    @Column(length = 255, nullable = false)
    private String nombre;

    @Column(length = 255)
    private String contacto;

    @Column(columnDefinition = "TEXT")
    private String direccion;

    @Column(name = "productos_ofrecidos", columnDefinition = "TEXT")
    private String productosOfrecidos;


}
