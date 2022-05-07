package com.ceiba.docente.servicio.testdatabuilder;

import com.ceiba.docente.modelo.entidad.Docente;

public class DocenteTestDataBuilder {

    private Long id;
    private String identificacionDocente;
    private String nombreDocente;
    private String apellidoDocente;
    private String direccion;
    private String telefono;
    private String correoElectronico;

    public DocenteTestDataBuilder(){
        identificacionDocente = "12345";
        nombreDocente = "12345";
        apellidoDocente = "12345";
        direccion = "12345";
        telefono = "12345";
        correoElectronico = "12345";
    }

    public DocenteTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public DocenteTestDataBuilder conIdentificacion(String identificacionDocente){
        this.identificacionDocente = identificacionDocente;
        return this;
    }

    public DocenteTestDataBuilder conNombre(String nombreDocente){
        this.nombreDocente = nombreDocente;
        return this;
    }

    public DocenteTestDataBuilder conApellido(String apellidoDocente){
        this.apellidoDocente = apellidoDocente;
        return this;
    }

    public DocenteTestDataBuilder conDireccion(String direccion){
        this.direccion = direccion;
        return this;
    }

    public DocenteTestDataBuilder conTelefono(String telefono){
        this.telefono = telefono;
        return this;
    }

    public DocenteTestDataBuilder conCorreoElectronico(String correoElectronico){
        this.correoElectronico = correoElectronico;
        return this;
    }

    public Docente build(){
        return new Docente(id,identificacionDocente, nombreDocente, apellidoDocente, direccion, telefono, correoElectronico);
    }
}
