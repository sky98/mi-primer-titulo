package com.ceiba.alumno.servicio.testdatabuilder;

import com.ceiba.alumno.modelo.entidad.Alumno;

public class AlumnoTestDataBuilder {

    private Long id;
    private String identificacionAlumno;
    private String nombreAlumno;
    private String apellidoAlumno;
    private String direccion;
    private String telefono;
    private String correoElectronico;

    public AlumnoTestDataBuilder(){
        identificacionAlumno = "12345";
        nombreAlumno = "12345";
        apellidoAlumno = "12345";
        direccion = "12345";
        telefono = "12345";
        correoElectronico = "12345";
    }
    public AlumnoTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }
    public AlumnoTestDataBuilder conIdentificacion(String identificacionAlumno){
        this.identificacionAlumno = identificacionAlumno;
        return this;
    }
    public AlumnoTestDataBuilder conNombre(String nombreAlumno){
        this.nombreAlumno = nombreAlumno;
        return this;
    }
    public AlumnoTestDataBuilder conApellido(String apellidoAlumno){
        this.apellidoAlumno = apellidoAlumno;
        return this;
    }
    public AlumnoTestDataBuilder conDireccion(String direccion){
        this.direccion = direccion;
        return this;
    }
    public AlumnoTestDataBuilder conTelefono(String telefono){
        this.telefono = telefono;
        return this;
    }
    public AlumnoTestDataBuilder conCorreoElectronico(String correoElectronico){
        this.correoElectronico = correoElectronico;
        return this;
    }
    public Alumno build(){
        return new Alumno(id, identificacionAlumno, nombreAlumno, apellidoAlumno, direccion, telefono, correoElectronico);
    }
}
