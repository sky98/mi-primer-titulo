package com.ceiba.docente.puerto.dao;

import com.ceiba.docente.modelo.dto.DtoDocente;

import java.util.List;

public interface DaoDocente {

    /**
     * Permite listar docentes
     * @return los docentes
     */
    List<DtoDocente> listar();
}
