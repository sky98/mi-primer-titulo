package com.ceiba.clase.servicio;

import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.puerto.repositorio.RepositorioClase;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorNoEncontrado;

public class ServicioCrearClase {

    private static final String LA_CLASE_YA_EXISTE_EN_EL_SISTEMA = "La clase ya existe en el sistema";
    private static final String EL_DOCENTE_NO_EXISTE_EN_EL_SISTEMA = "El docente no existe en el sistema";
    private static final String DOCENTE_SUPERA_LIMITE_DE_HORAS_MAXIMAS = "Docente supera limite de horas máximas";
    private static final String EL_CURSO_NO_EXISTE_EN_EL_SISTEMA = "El curso no existe en el sistema";
    private final RepositorioClase repositorioClase;

    public ServicioCrearClase(RepositorioClase repositorioClase) {
        this.repositorioClase = repositorioClase;
    }

    public Long ejecutar(Clase clase){
        validarExistenciaPrevia(clase);
        validarExistenciaDocente(clase);
        validarExistenciaCurso(clase);
        validarHorasDocente(clase);
        return this.repositorioClase.crear(clase);
    }

    private void validarExistenciaPrevia(Clase clase){
        boolean existe = repositorioClase.existePorId(clase.getId());
        if(existe){
            throw new ExcepcionDuplicidad(LA_CLASE_YA_EXISTE_EN_EL_SISTEMA);
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
    private void validarHorasDocente(Clase clase){
        Integer horasRegistradas = repositorioClase.validaHorasDocente(clase.getDocente(), clase.getCurso());
        if(horasRegistradas > 15){
            throw new ExcepcionValorInvalido(DOCENTE_SUPERA_LIMITE_DE_HORAS_MAXIMAS);
        }
    }
}
