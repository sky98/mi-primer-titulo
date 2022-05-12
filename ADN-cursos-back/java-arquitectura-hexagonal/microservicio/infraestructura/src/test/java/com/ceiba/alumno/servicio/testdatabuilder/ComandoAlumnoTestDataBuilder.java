package com.ceiba.alumno.servicio.testdatabuilder;

import com.ceiba.alumno.comando.ComandoAlumno;

public class ComandoAlumnoTestDataBuilder {

    private Long id;
    private String identificacion;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correoElectronico;

    public ComandoAlumnoTestDataBuilder(){
        id = 1234L;
        identificacion = "1234";
        nombre = "1234";
        apellido = "1234";
        direccion = "1234";
        telefono = "1234";
        correoElectronico = "1234";
    }

    public ComandoAlumnoTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public ComandoAlumnoTestDataBuilder conIdentificacion(String identificacion){
        this.identificacion =  identificacion;
        return this;
    }
    public ComandoAlumnoTestDataBuilder conNombre(String nombre){
        this.nombre =  nombre;
        return this;
    }
    public ComandoAlumnoTestDataBuilder conApellido(String apellido){
        this.apellido =  apellido;
        return this;
    }
    public ComandoAlumnoTestDataBuilder conDireccion(String direccion){
        this.direccion =  direccion;
        return this;
    }
    public ComandoAlumnoTestDataBuilder conTelefono(String telefono){
        this.telefono =  telefono;
        return this;
    }
    public ComandoAlumnoTestDataBuilder conCorreoElectronico(String correoElectronico){
        this.correoElectronico =  correoElectronico;
        return this;
    }

    public ComandoAlumno build(){
        return new ComandoAlumno(id, identificacion, nombre, apellido, direccion, telefono, correoElectronico);
    }
}
