package com.ceiba.clase.servicio.testdatabuilder;

import com.ceiba.clase.comando.ComandoClase;

public class ComandoClaseTestDataBuilder {
    private Long id;
    private String nombre;
    private Long docente;
    private Long curso;

    public ComandoClaseTestDataBuilder(){
        id = 2L;
        nombre = "1";
        docente = 1L;
        curso = 1L;
    }
    public ComandoClaseTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }
    public ComandoClaseTestDataBuilder conNombre(String nombre){
        this.nombre =  nombre;
        return this;
    }
    public ComandoClaseTestDataBuilder conDocente(Long docente){
        this.docente =  docente;
        return this;
    }
    public ComandoClaseTestDataBuilder conCurso(Long curso){
        this.curso =  curso;
        return this;
    }
    public ComandoClase build(){
        return new ComandoClase(id, nombre, docente, curso);
    }
}
