package com.ceiba.horario.modelo.dto;

import com.ceiba.dominio.utiles.DiasSemana;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoHorario {
    private Long id;
    private Long clase;
    private DiasSemana dia;
    private LocalDateTime horaInicio;
    private int cantidadHoras;
}
