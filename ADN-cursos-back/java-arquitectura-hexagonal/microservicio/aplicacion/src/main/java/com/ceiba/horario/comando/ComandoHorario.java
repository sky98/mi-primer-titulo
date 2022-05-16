package com.ceiba.horario.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoHorario {

    private Long id;
    private Long clase;
    private Integer dia;
    private Integer horaInicio;
    private Integer cantidadHoras;
}
