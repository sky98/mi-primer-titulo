package com.ceiba.persona.puerto.dao;

import com.ceiba.persona.modelo.dto.DtoPersona;

import java.util.List;

public interface DaoPersona {

    /**
     * Permite listar personas
     * @return los personas
     */
    List<DtoPersona> listar();

    /**
     * Permite listar alumnos
     * @return los alumnos
     */
    List<DtoPersona> listarAlumnos();

    /**
     * Permite listar alumnos
     * @return los alumnos
     */
    List<DtoPersona> listarDocentes();
}
