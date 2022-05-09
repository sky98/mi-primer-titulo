package com.ceiba.docente.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Docente {

    private static final String SE_DEBE_INGRESAR_LA_IDENTIFICACION = "Se debe ingresar la identificación del docente";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el nombre del docente";
    private static final String SE_DEBE_INGRESAR_EL_APELLIDO = "Se debe ingresar el apellido del docente";
    private static final String SE_DEBE_INGRESAR_LA_DIRECCION = "Se debe ingresar la dirección del docente";
    private static final String SE_DEBE_INGRESAR_EL_TELEFONO = "Se debe ingresar el telefono del docente";
    private static final String SE_DEBE_INGRESAR_EL_CORREO_ELECTRONICO = "Se debe ingresar el correo electronico del docente";
    private static final String LA_IDENTIFICACION_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "La identificación debe tener una longitud mayor o igual a %s";

    private static final int LONGITUD_MINIMA_IDENTIFICACION = 4;

    private Long id;
    private String identificacion;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correoElectronico;

    public Docente(Long id,String identificacion, String nombre, String apellido, String direccion, String telefono, String correoElectronico){
        validarObligatorio(identificacion, SE_DEBE_INGRESAR_LA_IDENTIFICACION);
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE);
        validarObligatorio(apellido, SE_DEBE_INGRESAR_EL_APELLIDO);
        validarObligatorio(direccion, SE_DEBE_INGRESAR_LA_DIRECCION);
        validarObligatorio(telefono, SE_DEBE_INGRESAR_EL_TELEFONO);
        validarObligatorio(correoElectronico, SE_DEBE_INGRESAR_EL_CORREO_ELECTRONICO);
        validarLongitud(identificacion, LONGITUD_MINIMA_IDENTIFICACION, LA_IDENTIFICACION_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A);

        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

}
