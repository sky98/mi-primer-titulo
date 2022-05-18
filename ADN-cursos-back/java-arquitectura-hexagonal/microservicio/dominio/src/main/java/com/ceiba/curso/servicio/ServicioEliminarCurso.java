package com.ceiba.curso.servicio;

import com.ceiba.curso.puerto.repositorio.RepositorioCurso;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioEliminarCurso {

        private static final String EL_CURSO_NO_EXISTE_EN_EL_SISTEMA = "El curso no existe en el sistema";

    private final RepositorioCurso repositorioCurso;

    public ServicioEliminarCurso(RepositorioCurso repositorioCurso) {
        this.repositorioCurso = repositorioCurso;
    }

    public void ejecutar(Long id) {
        validarExistenciaPrevia(id);
        this.repositorioCurso.eliminar(id);
    }

    private void validarExistenciaPrevia(long salon) {
        boolean existe = repositorioCurso.existePorId(salon);
        if (!existe) {
            throw new ExcepcionDuplicidad(EL_CURSO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}