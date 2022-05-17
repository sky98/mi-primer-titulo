package com.ceiba.curso.servicio.testdatabuilder;

import com.ceiba.curso.modelo.entidad.Curso;

public class CursoTestDataBuilder {
    private Long id;
    private String identificacion;
    private String nombre;
    private String descripcion;
    private Integer horas;

    public CursoTestDataBuilder(){
        identificacion = "12345";
        nombre = "12345";
        descripcion = "12345";
        horas = 2;
    }
    public CursoTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }
    public CursoTestDataBuilder conIdentificacion(String identificacion){
        this.identificacion = identificacion;
        return this;
    }
    public CursoTestDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    public CursoTestDataBuilder conDescripcion(String descripcion){
        this.descripcion = descripcion;
        return this;
    }
    public CursoTestDataBuilder conHoras(Integer horas){
        this.horas = horas;
        return this;
    }
    public Curso build(){
        return new Curso(id, identificacion, nombre, descripcion, horas);
    }
}
