package com.example.proyecto_final.Dto;

import com.example.proyecto_final.Model.Proveedor;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoDTO {
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer categoriaId;  // Solo el ID, no el objeto completo
    private String imagen;
    private Integer stock;
    private Integer proveedor;
}
