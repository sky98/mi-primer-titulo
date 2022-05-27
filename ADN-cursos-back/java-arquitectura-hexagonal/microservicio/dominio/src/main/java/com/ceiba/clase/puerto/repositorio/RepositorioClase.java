package com.ceiba.clase.puerto.repositorio;

import com.ceiba.base.BaseRepositorio;
import com.ceiba.clase.modelo.entidad.Clase;

public interface RepositorioClase extends BaseRepositorio<Clase> {

    /**
     * Permite validar si existe un curso con un id
     * @return si existe o no
     */
    boolean existeAsignacionCurso(Long curso);

    /**
     * Permite validar si existe un curso con un id
     * @return si existe o no
     */
    boolean existeCurso(Long curso);

    /**
     * Valida las horas del docente inscritas
     *  @param docente
     * @return total de horas
     */
    Integer validaHorasInscritasDocente(Long docente);

    /**
     * Obtiene las horas del curso nuevo
     *  @param curso
     * @return horas del curso
     */
    Integer obtenerHorasCurso(Long curso);
}
