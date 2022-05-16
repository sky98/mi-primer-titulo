package com.ceiba.salon.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Salon {
    private static final String SE_DEBE_INGRESAR_EL_ALUMNO = "Se debe ingresar el alumno";
    private static final String SE_DEBE_INGRESAR_EL_CURSO = "Se debe ingresar el curso";
    private Long id;
    private Long alumno;
    private Long curso;

    public Salon(Long id, Long alumno, Long curso){
        validarObligatorio(alumno, SE_DEBE_INGRESAR_EL_ALUMNO);
        validarObligatorio(curso, SE_DEBE_INGRESAR_EL_CURSO);
        this.id = id;
        this.alumno = alumno;
        this.curso = curso;
    }
}
