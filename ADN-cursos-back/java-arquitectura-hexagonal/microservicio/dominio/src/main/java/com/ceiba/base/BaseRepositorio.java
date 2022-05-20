package com.ceiba.base;

public interface BaseRepositorio<T> {

    /**
     * Permite crear una t
     * @param t
     * @return el id generado
     */
    Long crear(T t);

    /**
     * Permite actualizar una t
     * @param t
     */
    void actualizar(T t);

    /**
     * Permite eliminar una t
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un t con un id
     * @return si existe o no
     */
    boolean existePorId(Long id);
}
