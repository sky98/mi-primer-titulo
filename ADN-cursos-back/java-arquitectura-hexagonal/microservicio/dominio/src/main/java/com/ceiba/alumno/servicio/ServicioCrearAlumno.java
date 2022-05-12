package com.ceiba.alumno.servicio;

import com.ceiba.alumno.modelo.entidad.Alumno;
import com.ceiba.alumno.puerto.repositorio.RepositorioAlumno;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearAlumno {

    private static final String EL_ALUMNO_YA_EXISTE_EN_EL_SISTEMA = "El alumno ya existe en el sistema";

    private final RepositorioAlumno repositorioAlumno;

    public ServicioCrearAlumno(RepositorioAlumno repositorioAlumno) {
        this.repositorioAlumno = repositorioAlumno;
    }

    public Long ejecutar(Alumno alumno){
        validarExistenciaPrevia(alumno);
        return this.repositorioAlumno.crear(alumno);
    }

    private void validarExistenciaPrevia(Alumno alumno){
        boolean existe = repositorioAlumno.existePorIdentificacion(alumno.getIdentificacion());
        if(existe){
            throw new ExcepcionDuplicidad(EL_ALUMNO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
