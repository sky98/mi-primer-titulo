package com.ceiba.horario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoHorario {
    private Long id;
    private Long clase;
    private Integer dia;
    private Integer horaInicio;
    private Integer cantidadHoras;
}
