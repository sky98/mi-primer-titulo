package com.ceiba.clase.puerto.dao;

import com.ceiba.clase.modelo.dto.DtoClase;

import java.util.List;

public interface DaoClase {

    /**
     * Permite listar clases
     * @return los clases
     */
    List<DtoClase> listar();
}
