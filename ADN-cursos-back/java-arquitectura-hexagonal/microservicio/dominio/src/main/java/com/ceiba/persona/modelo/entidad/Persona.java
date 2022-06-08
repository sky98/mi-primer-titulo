package com.ceiba.persona.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Persona {

    private static final String SE_DEBE_INGRESAR_LA_IDENTIFICACION = "Se debe ingresar la identificación";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el nombre";
    private static final String SE_DEBE_INGRESAR_EL_APELLIDO = "Se debe ingresar el apellido";
    private static final String SE_DEBE_INGRESAR_LA_DIRECCION = "Se debe ingresar la dirección";
    private static final String SE_DEBE_INGRESAR_EL_TELEFONO = "Se debe ingresar el teléfono";
    private static final String SE_DEBE_INGRESAR_EL_CORREO_ELECTRONICO = "Se debe ingresar el correo electrónico";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_PERSONA = "Se debe ingresar el tipo de persona";
    private static final String TIPO_DE_PERSONA_NO_VALIDA = "Tipo de persona no valida";
    private static final String LA_IDENTIFICACION_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "La identificación debe tener una longitud mayor o igual a 4";

    private static final int LONGITUD_MINIMA_IDENTIFICACION = 4;

    private Long id;
    private String identificacion;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private int tipo;

    public Persona(Long id, String identificacion, String nombre, String apellido, String direccion, String telefono, String correoElectronico, int tipo){
        validarObligatorio(identificacion, SE_DEBE_INGRESAR_LA_IDENTIFICACION);
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE);
        validarObligatorio(apellido, SE_DEBE_INGRESAR_EL_APELLIDO);
        validarObligatorio(direccion, SE_DEBE_INGRESAR_LA_DIRECCION);
        validarObligatorio(telefono, SE_DEBE_INGRESAR_EL_TELEFONO);
        validarObligatorio(correoElectronico, SE_DEBE_INGRESAR_EL_CORREO_ELECTRONICO);
        validarObligatorio(tipo, SE_DEBE_INGRESAR_EL_TIPO_DE_PERSONA);
        validarPositivo(Double.valueOf(tipo), TIPO_DE_PERSONA_NO_VALIDA);
        validarMenor(tipo, 2, TIPO_DE_PERSONA_NO_VALIDA);
        validarLongitud(identificacion, LONGITUD_MINIMA_IDENTIFICACION, LA_IDENTIFICACION_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A);

        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.tipo = tipo;
    }

}
