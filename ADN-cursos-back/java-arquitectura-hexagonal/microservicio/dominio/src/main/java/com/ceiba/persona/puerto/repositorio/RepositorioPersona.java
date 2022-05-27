package com.ceiba.persona.puerto.repositorio;

import com.ceiba.base.BaseRepositorio;
import com.ceiba.persona.modelo.entidad.Persona;

public interface RepositorioPersona extends BaseRepositorio<Persona> {

    /**
     * Permite validar si existe una persona por su identificación
     * @return si existe o no
     */
    boolean existePorIdentificacion(String identificacion);
}
