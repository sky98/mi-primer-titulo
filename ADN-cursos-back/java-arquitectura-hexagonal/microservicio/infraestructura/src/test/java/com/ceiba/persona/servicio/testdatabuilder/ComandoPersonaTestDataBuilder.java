package com.ceiba.persona.servicio.testdatabuilder;

import com.ceiba.persona.comando.ComandoPersona;

public class ComandoPersonaTestDataBuilder {

    private Long id;
    private String identificacion;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private int tipo;

    public ComandoPersonaTestDataBuilder(){
        id = 1234L;
        identificacion = "123456";
        nombre = "12345";
        apellido = "12345";
        direccion = "12345";
        telefono = "12345";
        correoElectronico = "12345";
        tipo = 1;
    }

    public ComandoPersonaTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }
    public ComandoPersonaTestDataBuilder conIdentificacion(String identificacion){
        this.identificacion =  identificacion;
        return this;
    }
    public ComandoPersonaTestDataBuilder conNombre(String nombre){
        this.nombre =  nombre;
        return this;
    }
    public ComandoPersonaTestDataBuilder conApellido(String apellido){
        this.apellido =  apellido;
        return this;
    }
    public ComandoPersonaTestDataBuilder conDireccion(String direccion){
        this.direccion =  direccion;
        return this;
    }
    public ComandoPersonaTestDataBuilder conTelefono(String telefono){
        this.telefono =  telefono;
        return this;
    }
    public ComandoPersonaTestDataBuilder conCorreoElectronico(String correoElectronico){
        this.correoElectronico =  correoElectronico;
        return this;
    }
    public ComandoPersonaTestDataBuilder conTipo(int tipo){
        this.tipo =  tipo;
        return this;
    }
    public ComandoPersona build(){
        return new ComandoPersona(id, identificacion, nombre, apellido, direccion, telefono, correoElectronico, tipo);
    }
}
