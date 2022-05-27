package com.ceiba.salon.puerto.repositorio;


import com.ceiba.base.BaseRepositorio;
import com.ceiba.salon.modelo.entidad.Salon;

public interface RepositorioSalon extends BaseRepositorio<Salon> {

    /**
     * Permite validar si existe un curso con un id
     * @return si existe o no
     */
    boolean existeCurso(Long curso);

    /**
     * Permite validar si existe un alumno por el id
     * @return si existe o no
     */
    boolean existeAlumno(Long alumno);

    /**
     * Obtiene la cantidad de alumnos inscritos a un curso
     *  @param curso
     * @return horas del curso
     */
    Integer obtenerCantidadAlumnos(Long curso);

    /**
     * Permite obtener el total de horas inscritas por el alumno
     * @return total de las horas
     */
    Integer contadorHorasAlumno(Long id);

    /**
     * Obtiene las horas del curso nuevo
     *  @param curso
     * @return horas del curso
     */
    Integer obtenerHorasCurso(Long curso);
}
