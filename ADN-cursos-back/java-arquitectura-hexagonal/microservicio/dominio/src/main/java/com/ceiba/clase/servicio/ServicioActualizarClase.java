package com.ceiba.clase.servicio;

import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.puerto.repositorio.RepositorioClase;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorNoEncontrado;

public class ServicioActualizarClase {

    private static final String LA_CLASE_NO_EXISTE_EN_EL_SISTEMA = "La clase no existe en el sistema";
    private static final String EL_DOCENTE_NO_EXISTE_EN_EL_SISTEMA = "El docente no existe en el sistema";
    private static final String EL_CURSO_NO_EXISTE_EN_EL_SISTEMA = "El curso no existe en el sistema";
    private final RepositorioClase repositorioClase;

    public ServicioActualizarClase(RepositorioClase repositorioClase) {
        this.repositorioClase = repositorioClase;
    }

    public void ejecutar(Clase clase) {
        validarExistenciaPrevia(clase);
        validarExistenciaDocente(clase);
        validarExistenciaCurso(clase);
        this.repositorioClase.actualizar(clase);
    }
    private void validarExistenciaPrevia(Clase clase) {
        boolean existe = this.repositorioClase.existePorId(clase.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(LA_CLASE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
    private void validarExistenciaDocente(Clase clase){
        boolean existe = repositorioClase.existeDocente(clase.getDocente());
        if(!existe){
            throw new ExcepcionValorNoEncontrado(EL_DOCENTE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
    private void validarExistenciaCurso(Clase clase){
        boolean existe = repositorioClase.existeCurso(clase.getCurso());
        if(!existe){
            throw new ExcepcionValorNoEncontrado(EL_CURSO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
