package com.ceiba.curso.servicio;

import com.ceiba.curso.modelo.entidad.Curso;
import com.ceiba.curso.puerto.repositorio.RepositorioCurso;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearCurso {

    private static final String EL_CURSO_YA_EXISTE_EN_EL_SISTEMA = "El curso ya existe en el sistema";

    private final RepositorioCurso repositorioCurso;

    public ServicioCrearCurso(RepositorioCurso repositorioCurso) {
        this.repositorioCurso = repositorioCurso;
    }

    public Long ejecutar(Curso curso){
        validarExistenciaPrevia(curso);
        return this.repositorioCurso.crear(curso);
    }

    private void validarExistenciaPrevia(Curso curso){
        boolean existe = repositorioCurso.existePorIdentificacion(curso.getIdentificacion());
        if(existe){
            throw new ExcepcionDuplicidad(EL_CURSO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
