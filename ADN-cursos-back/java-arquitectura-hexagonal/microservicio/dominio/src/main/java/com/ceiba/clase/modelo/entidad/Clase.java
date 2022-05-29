package com.ceiba.clase.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Clase {
    private static final String SE_DEBE_INGRESAR_EL_CURSO = "Se debe ingresar el curso";
    private static final String SE_DEBE_INGRESAR_EL_DOCENTE = "Se debe ingresar el docente";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_CLASE = "Se debe ingresar el nombre de la clase";
    private Long id;
    private String nombre;
    private Long docente;
    private Long curso;

    public Clase(Long id, String nombre, Long docente, Long curso){
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_CLASE);
        validarObligatorio(docente, SE_DEBE_INGRESAR_EL_DOCENTE);
        validarObligatorio(curso, SE_DEBE_INGRESAR_EL_CURSO);
        this.id = id;
        this.nombre = nombre;
        this.docente = docente;
        this.curso = curso;
    }

}
