package com.ceiba.salon.puerto.dao;

import com.ceiba.salon.modelo.dto.DtoSalon;

import java.util.List;

public interface DaoSalon {

    /**
     * Permite listar salones
     * @return los salons
     */
    List<DtoSalon> listar();
}
