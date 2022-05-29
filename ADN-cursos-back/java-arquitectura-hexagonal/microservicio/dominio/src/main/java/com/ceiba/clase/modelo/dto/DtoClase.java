package com.ceiba.clase.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoClase {
    private Long id;
    private String nombre;
    private Long docente;
    private Long curso;
}
