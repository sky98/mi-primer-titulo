package com.ceiba.salon.servicio.testdatabuilder;

import com.ceiba.salon.modelo.entidad.Salon;

public class SalonTestDataBuilder {

    private Long id;
    private Long alumno;
    private Long curso;

    public SalonTestDataBuilder() {
        id = 1L;
        alumno = 1L;
        curso = 1L;
    }
    public SalonTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }
    public SalonTestDataBuilder conAlumno(Long alumno) {
        this.alumno = alumno;
        return this;
    }
    public SalonTestDataBuilder conCurso(Long curso) {
        this.curso = curso;
        return this;
    }
    public Salon build() {
        return new Salon(id, alumno, curso);
    }
}
