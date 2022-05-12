package com.ceiba.alumno.servicio;

import com.ceiba.alumno.modelo.entidad.Alumno;
import com.ceiba.alumno.puerto.repositorio.RepositorioAlumno;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarAlumno {

    private static final String EL_ALUMNO_NO_EXISTE_EN_EL_SISTEMA = "El alumno no existe en el sistema";

    private final RepositorioAlumno repositorioAlumno;

    public ServicioActualizarAlumno(RepositorioAlumno repositorioAlumno) {
        this.repositorioAlumno = repositorioAlumno;
    }

    public void ejecutar(Alumno alumno) {
        validarExistenciaPrevia(alumno);
        this.repositorioAlumno.actualizar(alumno);
    }

    private void validarExistenciaPrevia(Alumno alumno) {
        boolean existe = this.repositorioAlumno.existePorId(alumno.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_ALUMNO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
