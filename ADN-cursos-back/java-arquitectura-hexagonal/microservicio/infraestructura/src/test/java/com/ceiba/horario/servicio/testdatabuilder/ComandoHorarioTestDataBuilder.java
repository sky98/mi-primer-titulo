package com.ceiba.horario.servicio.testdatabuilder;

import com.ceiba.horario.comando.ComandoHorario;

public class ComandoHorarioTestDataBuilder {

    private Long id;
    private Long clase;
    private Integer dia;
    private Integer horaInicio;
    private Integer cantidadHoras;

    public ComandoHorarioTestDataBuilder(){
        id = 2L;
        clase = 1L;
        dia = 1;
        horaInicio = 10;
        cantidadHoras = 2;
    }
    public ComandoHorarioTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }
    public ComandoHorarioTestDataBuilder conClase(Long clase){
        this.clase =  clase;
        return this;
    }
    public ComandoHorarioTestDataBuilder conDia(Integer dia){
        this.dia =  dia;
        return this;
    }
    public ComandoHorarioTestDataBuilder conHoraInicio(Integer horaInicio){
        this.horaInicio =  horaInicio;
        return this;
    }
    public ComandoHorarioTestDataBuilder conCantidadHoras(Integer cantidadHoras){
        this.cantidadHoras =  cantidadHoras;
        return this;
    }
    public ComandoHorario build(){
        return new ComandoHorario(id, clase, dia, horaInicio, cantidadHoras);
    }
}
