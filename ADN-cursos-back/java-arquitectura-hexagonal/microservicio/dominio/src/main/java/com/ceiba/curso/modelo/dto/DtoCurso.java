package com.ceiba.curso.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoCurso {

    private Long id;
    private String identificacion;
    private String nombre;
    private String descripcion;
    private Integer horas;
}
