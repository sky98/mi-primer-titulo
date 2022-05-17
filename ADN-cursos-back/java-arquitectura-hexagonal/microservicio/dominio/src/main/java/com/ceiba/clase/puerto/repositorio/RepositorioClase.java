package com.ceiba.clase.puerto.repositorio;

import com.ceiba.clase.modelo.entidad.Clase;

public interface RepositorioClase {

    /**
     * Permite crear una clase
     * @param clase
     * @return el id generado
     */
    Long crear(Clase clase);

    /**
     * Permite actualizar una clase
     * @param clase
     */
    void actualizar(Clase clase);

    /**
     * Permite eliminar una clase
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un clase con un id
     * @return si existe o no
     */
    boolean existePorId(Long id);

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
