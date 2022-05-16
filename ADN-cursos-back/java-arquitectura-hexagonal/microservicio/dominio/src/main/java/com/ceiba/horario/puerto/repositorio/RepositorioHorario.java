package com.ceiba.horario.puerto.repositorio;

import com.ceiba.horario.modelo.entidad.Horario;

public interface RepositorioHorario {
    /**
     * Permite crear un horario
     * @param horario
     * @return el id generado
     */
    Long crear(Horario horario);

    /**
     * Permite actualizar un horario
     * @param horario
     */
    void actualizar(Horario horario);

    /**
     * Permite eliminar un horario
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un horario con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long id);
}
