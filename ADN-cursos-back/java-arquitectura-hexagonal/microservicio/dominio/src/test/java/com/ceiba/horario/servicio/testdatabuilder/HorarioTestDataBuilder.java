package com.ceiba.horario.servicio.testdatabuilder;

import com.ceiba.horario.modelo.entidad.Horario;

public class HorarioTestDataBuilder {

    private Long id;
    private Long clase;
    private Integer dia;
    private Integer horaInicio;
    private Integer cantidadHoras;

    public HorarioTestDataBuilder() {
        id = 1L;
        clase = 1L;
        dia = 1;
        horaInicio = 8;
        cantidadHoras = 2;
    }

    public HorarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public HorarioTestDataBuilder conClase(Long clase) {
        this.clase = clase;
        return this;
    }

    public HorarioTestDataBuilder conDia(Integer dia) {
        this.dia = dia;
        return this;
    }

    public HorarioTestDataBuilder conHoraInicio(Integer horaInicio) {
        this.horaInicio = horaInicio;
        return this;
    }
    public HorarioTestDataBuilder conCantidadHoras(Integer cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
        return this;
    }
    public Horario build() {
        return new Horario(id, clase, dia, horaInicio, cantidadHoras);
    }
}
