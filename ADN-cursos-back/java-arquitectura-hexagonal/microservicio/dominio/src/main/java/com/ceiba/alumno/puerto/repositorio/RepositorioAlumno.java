package com.ceiba.alumno.puerto.repositorio;

import com.ceiba.alumno.modelo.entidad.Alumno;

public interface RepositorioAlumno {

    /**
     * Permite crear un alumno
     * @param alumno
     * @return el id generado
     */
    Long crear(Alumno alumno);

    /**
     * Permite actualizar un alumno
     * @param alumno
     */
    void actualizar(Alumno alumno);

    /**
     * Permite eliminar un alumno
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un alumno con una identificacion
     * @return si existe o no
     */
    boolean existePorIdentificacion(String identificacion);

    /**
     * Permite validar si existe un alumno con una id
     * @return si existe o no
     */
    boolean existePorId(Long id);
}
