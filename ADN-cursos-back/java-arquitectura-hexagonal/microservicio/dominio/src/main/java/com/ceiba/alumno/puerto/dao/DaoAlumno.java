package com.ceiba.alumno.puerto.dao;

import com.ceiba.alumno.modelo.dto.DtoAlumno;

import java.util.List;

public interface DaoAlumno {

    /**
     * Permite listar docentes
     * @return los docentes
     */
    List<DtoAlumno> listar();
}
