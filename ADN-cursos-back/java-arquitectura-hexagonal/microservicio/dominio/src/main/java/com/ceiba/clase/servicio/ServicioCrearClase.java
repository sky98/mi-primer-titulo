package com.ceiba.clase.servicio;

import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.puerto.repositorio.RepositorioClase;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorNoEncontrado;

public class ServicioCrearClase {

    private static final String LA_CLASE_YA_ESTA_REGISTRADA_EN_EL_SISTEMA = "La clase ya esta registrada en el sistema";
    private static final String EL_DOCENTE_NO_PUEDE_SUPERAR_EL_LIMITE_DE_HORAS_MAXIMAS = "El docente no puede superar el limite de horas máximas";
    private static final String EL_CURSO_YA_EXISTE_EN_EL_SISTEMA = "El curso ya existe en el sistema";
    private final RepositorioClase repositorioClase;

    public ServicioCrearClase(RepositorioClase repositorioClase) {
        this.repositorioClase = repositorioClase;
    }

    public Long ejecutar(Clase clase){
        validarExistenciaPrevia(clase);
        validarExistenciaPreviaCurso(clase);
        validarHorasDocente(clase);
        return this.repositorioClase.crear(clase);
    }
    private void validarExistenciaPrevia(Clase clase){
        boolean existe = repositorioClase.existePorId(clase.getId());
        if(existe){
            throw new ExcepcionDuplicidad(LA_CLASE_YA_ESTA_REGISTRADA_EN_EL_SISTEMA);
        }
    }
    private void validarExistenciaPreviaCurso(Clase clase){
        boolean existe = repositorioClase.existeCurso(clase.getCurso());
        if(existe){
            throw new ExcepcionValorNoEncontrado(EL_CURSO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
    private void validarHorasDocente(Clase clase){
        Integer horasRegistradas = repositorioClase.validaHorasInscritasDocente(clase.getDocente());
        Integer horaCursoNuevo = repositorioClase.obtenerHorasCurso(clase.getCurso());
        horaCursoNuevo = (horasRegistradas == null)? horaCursoNuevo: horasRegistradas+horaCursoNuevo;
        if(horaCursoNuevo > 15 ){
            throw new ExcepcionValorInvalido(EL_DOCENTE_NO_PUEDE_SUPERAR_EL_LIMITE_DE_HORAS_MAXIMAS);
        }
    }
}
