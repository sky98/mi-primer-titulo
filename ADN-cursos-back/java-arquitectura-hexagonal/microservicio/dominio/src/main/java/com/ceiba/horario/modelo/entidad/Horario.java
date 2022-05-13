package com.ceiba.horario.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Horario {

    private static final String SE_DEBE_INGRESAR_LA_CLASE = "Se debe ingresar la clase";
    private static final String SE_DEBE_INGRESAR_EL_DIA = "Se debe ingresar el día";
    private static final String SE_DEBE_INGRESAR_LA_HORA_DE_INICIO_DE_LA_CLASE = "Se debe ingresar la hora de inicio de la clase";
    private static final String SE_DEBE_INGRESAR_LA_CANTIDAD_DE_HORAS = "Se debe ingresar la cantidad de horas de la clase";
    private static final String LA_IDENTIFICACION_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "La identificación debe tener una longitud mayor o igual a 4";

    private static final int LONGITUD_MAXIMA_HORAS = 4;

    private Long id;
    private Long clase;
    private String dia;
    private LocalDateTime horaInicio;
    private int cantidadHoras;

    public Horario(Long id, Long clase, String dia, LocalDateTime horaInicio, int cantidadHoras){
        validarObligatorio(clase, SE_DEBE_INGRESAR_LA_CLASE);
        validarObligatorio(dia, SE_DEBE_INGRESAR_EL_DIA);
        validarObligatorio(horaInicio, SE_DEBE_INGRESAR_LA_HORA_DE_INICIO_DE_LA_CLASE);
        validarObligatorio(cantidadHoras, SE_DEBE_INGRESAR_LA_CANTIDAD_DE_HORAS);

        this.id = id;
        this.clase = clase;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.cantidadHoras = cantidadHoras;
    }

}
