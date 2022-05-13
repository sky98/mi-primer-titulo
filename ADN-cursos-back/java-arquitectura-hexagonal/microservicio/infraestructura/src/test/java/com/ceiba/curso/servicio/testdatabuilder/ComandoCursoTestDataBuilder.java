package com.ceiba.curso.servicio.testdatabuilder;

import com.ceiba.curso.comando.ComandoCurso;

import java.util.UUID;

public class ComandoCursoTestDataBuilder {

    private Long id;
    private String identificacion;
    private String nombre;
    private String descripcion;
    private Integer horas;
    private Long docente;

    public ComandoCursoTestDataBuilder(){
        id = 12345L;
        identificacion = UUID.randomUUID().toString();
        nombre = "1234";
        descripcion = "1234";
        horas = 1;
        docente = 1L;
    }
    public ComandoCursoTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }
    public ComandoCursoTestDataBuilder conIdentificacion(String identificacion){
        this.identificacion =  identificacion;
        return this;
    }
    public ComandoCursoTestDataBuilder conNombre(String nombre){
        this.nombre =  nombre;
        return this;
    }
    public ComandoCursoTestDataBuilder conDescripcion(String descripcion){
        this.descripcion =  descripcion;
        return this;
    }
    public ComandoCursoTestDataBuilder conHoras(Integer horas){
        this.horas =  horas;
        return this;
    }
    public ComandoCursoTestDataBuilder conDocente(Long docente){
        this.docente = docente;
        return this;
    }
    public ComandoCurso build(){
        return new ComandoCurso(id, identificacion, nombre, descripcion, horas, docente);
    }
}
