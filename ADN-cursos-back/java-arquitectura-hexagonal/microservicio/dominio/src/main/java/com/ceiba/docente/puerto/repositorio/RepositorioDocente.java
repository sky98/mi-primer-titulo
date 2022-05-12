package com.ceiba.docente.puerto.repositorio;

import com.ceiba.docente.modelo.entidad.Docente;

public interface RepositorioDocente {

    /**
     * Permite crear un docente
     * @param docente
     * @return el id generado
     */
    Long crear(Docente docente);

    /**
     * Permite actualizar un docente
     * @param docente
     */
    void actualizar(Docente docente);

    /**
     * Permite eliminar un docente
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un docente con una identificacion
     * @return si existe o no
     */
    boolean existePorIdentificacion(String identificacion);

    /**
     * Permite validar si existe un docente con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long id);
}
