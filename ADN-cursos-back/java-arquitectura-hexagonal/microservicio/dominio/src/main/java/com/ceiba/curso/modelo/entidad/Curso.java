package com.ceiba.curso.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Curso {

    private static final String EL_VALOR_MINIMO_DE_HORAS = "El valor mínimo de horas es 1";
    private static final String EL_VALOR_MAXIMO_DE_HORAS = "El valor máximo de horas es 4";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el nombre del curso";
    private static final String SE_DEBE_INGRESAR_LA_DESCRIPCION = "Se debe ingresar la descripción del curso";
    private static final String SE_DEBE_INGRESAR_LAS_HORAS = "Se debe ingresar las horas del curso";

    private static final int LONGITUD_MINIMA_HORAS = 1;
    private static final int LONGITUD_MAXIMA_HORAS = 4;

    private Long id;
    private String identificacion;
    private String nombre;
    private String descripcion;
    private Integer horas;

    public Curso(Long id, String identificacion, String nombre, String descripcion, Integer horas){

        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE);
        validarObligatorio(descripcion, SE_DEBE_INGRESAR_LA_DESCRIPCION);
        validarObligatorio(horas, SE_DEBE_INGRESAR_LAS_HORAS);

        validarMenor(LONGITUD_MINIMA_HORAS, horas, EL_VALOR_MINIMO_DE_HORAS);
        validarMenor(horas, LONGITUD_MAXIMA_HORAS, EL_VALOR_MAXIMO_DE_HORAS);

        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horas = horas;
    }

}
