package com.ceiba.clase.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarMenor;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Clase {
    private static final String SE_DEBE_INGRESAR_EL_CURSO = "Se debe ingresar el curso";
    private static final String SE_DEBE_INGRESAR_EL_DOCENTE = "Se debe ingresar el docente";
    private Long id;
    private Long docente;
    private Long curso;

    public Clase(Long id, Long docente, Long curso){
        validarObligatorio(docente, SE_DEBE_INGRESAR_EL_DOCENTE);
        validarObligatorio(curso, SE_DEBE_INGRESAR_EL_CURSO);
        this.id = id;
        this.docente = docente;
        this.curso = curso;
    }

}
