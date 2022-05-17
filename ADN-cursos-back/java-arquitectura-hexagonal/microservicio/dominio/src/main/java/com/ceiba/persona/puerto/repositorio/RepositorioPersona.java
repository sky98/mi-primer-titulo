package com.ceiba.persona.puerto.repositorio;

import com.ceiba.persona.modelo.entidad.Persona;

public interface RepositorioPersona {

    /**
     * Permite crear una persona
     * @param persona
     * @return el id generado
     */
    Long crear(Persona persona);

    /**
     * Permite actualizar una persona
     * @param persona
     */
    void actualizar(Persona persona);

    /**
     * Permite eliminar una persona
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe una persona por su identificación
     * @return si existe o no
     */
    boolean existePorIdentificacion(String identificacion);

    /**
     * Permite validar si existe una persona por el id
     * @return si existe o no
     */
    boolean existePorId(Long id);
}
