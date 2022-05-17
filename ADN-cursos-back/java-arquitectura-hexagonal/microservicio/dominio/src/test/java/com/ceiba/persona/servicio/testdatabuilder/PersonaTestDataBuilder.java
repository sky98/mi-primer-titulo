package com.ceiba.persona.servicio.testdatabuilder;

import com.ceiba.persona.modelo.entidad.Persona;

public class PersonaTestDataBuilder {
    private Long id;
    private String identificacion;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private int tipo;

    public PersonaTestDataBuilder(){
        identificacion = "12345";
        nombre = "12345";
        apellido = "12345";
        direccion = "12345";
        telefono = "12345";
        correoElectronico = "12345";
        tipo = 1;
    }
    public PersonaTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }
    public PersonaTestDataBuilder conIdentificacion(String identificacion){
        this.identificacion = identificacion;
        return this;
    }
    public PersonaTestDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    public PersonaTestDataBuilder conApellido(String apellido){
        this.apellido = apellido;
        return this;
    }
    public PersonaTestDataBuilder conDireccion(String direccion){
        this.direccion = direccion;
        return this;
    }
    public PersonaTestDataBuilder conTelefono(String telefono){
        this.telefono = telefono;
        return this;
    }
    public PersonaTestDataBuilder conCorreoElectronico(String correoElectronico){
        this.correoElectronico = correoElectronico;
        return this;
    }
    public PersonaTestDataBuilder conTipo(int tipo){
        this.tipo =  tipo;
        return this;
    }
    public Persona build(){
        return new Persona(id, identificacion, nombre, apellido, direccion, telefono, correoElectronico, tipo);
    }
}
