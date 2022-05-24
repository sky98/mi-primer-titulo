package com.ceiba.persona.puerto.dao;

import com.ceiba.persona.modelo.dto.DtoPersona;

import java.util.List;

public interface DaoPersona {

    /**
     * Permite listar personas
     * @return los personas
     */
    List<DtoPersona> listar(Long tipo);
}
