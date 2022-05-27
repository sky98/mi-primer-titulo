package com.ceiba.curso.puerto.repositorio;

import com.ceiba.base.BaseRepositorio;
import com.ceiba.curso.modelo.entidad.Curso;

public interface RepositorioCurso extends BaseRepositorio<Curso> {

    /**
     * Permite validar si existe un curso con una identificacion
     * @return si existe o no
     */
    boolean existePorIdentificacion(String identificacion);
}
