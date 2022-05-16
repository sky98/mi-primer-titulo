package com.ceiba.salon.servicio.testdatabuilder;

import com.ceiba.salon.comando.ComandoSalon;

public class ComandoSalonTestDataBuilder {

    private Long id;
    private Long alumno;
    private Long curso;

    public ComandoSalonTestDataBuilder(){
        id = 2L;
        alumno = 1L;
        curso = 1L;
    }
    public ComandoSalonTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }
    public ComandoSalonTestDataBuilder conAlumno(Long alumno){
        this.alumno =  alumno;
        return this;
    }
    public ComandoSalonTestDataBuilder conCurso(Long curso){
        this.curso =  curso;
        return this;
    }
    public ComandoSalon build(){
        return new ComandoSalon(id, alumno, curso);
    }
}
