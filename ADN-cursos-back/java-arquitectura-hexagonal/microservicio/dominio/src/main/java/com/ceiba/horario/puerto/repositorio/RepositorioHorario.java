package com.ceiba.horario.puerto.repositorio;

import com.ceiba.base.BaseRepositorio;
import com.ceiba.horario.modelo.entidad.Horario;

public interface RepositorioHorario extends BaseRepositorio<Horario> {

    /**
     * Permite validar si existe un clase por id
     * @return si existe o no
     */
    boolean existeClasePorId(Long id);

}
