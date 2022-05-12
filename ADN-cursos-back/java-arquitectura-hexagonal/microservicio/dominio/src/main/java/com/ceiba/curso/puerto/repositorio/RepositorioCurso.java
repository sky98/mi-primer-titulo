package com.ceiba.curso.puerto.repositorio;

import com.ceiba.curso.modelo.entidad.Curso;

public interface RepositorioCurso {

    /**
     * Permite crear un curso
     * @param curso
     * @return el id generado
     */
    Long crear(Curso curso);

    /**
     * Permite actualizar un curso
     * @param curso
     */
    void actualizar(Curso curso);

    /**
     * Permite eliminar un curso
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un curso con una identificacion
     * @return si existe o no
     */
    boolean existePorIdentificacion(String identificacion);

    /**
     * Permite validar si existe un curso con un id
     * @return si existe o no
     */
    boolean existePorId(Long id);
}
