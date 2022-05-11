package com.ceiba.docente.servicio.testdatabuilder;

import com.ceiba.docente.comando.ComandoDocente;

public class ComandoDocenteTestDataBuilder {

    private Long id;
    private String identificacion;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correoElectronico;

    public ComandoDocenteTestDataBuilder(){
        id = 1234L;
        identificacion = "1234";
        nombre = "1234";
        apellido = "1234";
        direccion = "1234";
        telefono = "1234";
        correoElectronico = "1234";
    }

    public ComandoDocenteTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public ComandoDocenteTestDataBuilder conIdentificacion(String identificacion){
        this.identificacion =  identificacion;
        return this;
    }
    public ComandoDocenteTestDataBuilder conNombre(String nombre){
        this.nombre =  nombre;
        return this;
    }
    public ComandoDocenteTestDataBuilder conApellido(String apellido){
        this.apellido =  apellido;
        return this;
    }
    public ComandoDocenteTestDataBuilder conDireccion(String direccion){
        this.direccion =  direccion;
        return this;
    }
    public ComandoDocenteTestDataBuilder conTelefono(String telefono){
        this.telefono =  telefono;
        return this;
    }
    public ComandoDocenteTestDataBuilder conCorreoElectronico(String correoElectronico){
        this.correoElectronico =  correoElectronico;
        return this;
    }

    public ComandoDocente build(){
        return new ComandoDocente(id, identificacion, nombre, apellido, direccion, telefono, correoElectronico);
    }
}
