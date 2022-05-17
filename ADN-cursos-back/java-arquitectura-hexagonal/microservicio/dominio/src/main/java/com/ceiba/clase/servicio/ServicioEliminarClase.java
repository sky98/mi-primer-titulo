package com.ceiba.clase.servicio;

import com.ceiba.clase.puerto.repositorio.RepositorioClase;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioEliminarClase {
    private static final String LA_CLASE_NO_EXISTE_EN_EL_SISTEMA = "La clase no existe en el sistema";
    private final RepositorioClase repositorioClase;

    public ServicioEliminarClase(RepositorioClase repositorioClase) {
        this.repositorioClase = repositorioClase;
    }

    public void ejecutar(Long id){
        validarExistenciaPrevia(id);
        this.repositorioClase.eliminar(id);
    }
    private void validarExistenciaPrevia(Long clase) {
        boolean existe = this.repositorioClase.existePorId(clase);
        if(!existe) {
            throw new ExcepcionDuplicidad(LA_CLASE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
