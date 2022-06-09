package com.ceiba.salon.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorNoEncontrado;
import com.ceiba.salon.modelo.entidad.Salon;
import com.ceiba.salon.puerto.repositorio.RepositorioSalon;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearSalon {

    private static final String REGISTRO_YA_SE_ENCUENTRA_EN_EL_SISTEMA = "Registro ya se encuentra en el sistema";
    private static final String NO_SE_PERMITE_PORQUE_EXCEDE_EL_MAXIMO_DE_HORAS_PERMITIDAS = "No se permite, porque excede el máximo de horas permitidas";
    private static final String CANTIDAD_MAXIMA_DE_ALUMNOS_PARA_UN_CURSO_ALCANZADA = "Cantidad maxima de alumnos para un curso alcanzada";
    private static final String EL_CURSO_NO_EXISTE_EN_EL_SISTEMA = "El curso no existe en el sistema";
    private static final String EL_ALUMNO_NO_EXISTE_EN_EL_SISTEMA = "El alumno no existe en el sistema";
    private static final int HORAS_MAXIMAS_ALUMNO = 30;
    private static final int CANTIDAD_MAXIMA_ALUMNO = 25;
    private final RepositorioSalon repositorioSalon;

    public ServicioCrearSalon(RepositorioSalon repositorioSalon) {
        this.repositorioSalon = repositorioSalon;
    }

    public Long ejecutar(Salon salon){
        validarExistenciaPrevia(salon);
        validarExistenciaPreviaCurso(salon);
        validarExistenciaPreviaAlumno(salon);
        validarCantidadAlumno(salon);
        validarHorasAlumno(salon);
        return this.repositorioSalon.crear(salon);
    }

    private void validarExistenciaPrevia(Salon salon){
        boolean existe = repositorioSalon.existePorId(salon.getId());
        if(existe){
            throw new ExcepcionDuplicidad(REGISTRO_YA_SE_ENCUENTRA_EN_EL_SISTEMA);
        }
    }
    private void validarExistenciaPreviaCurso(Salon salon){
        boolean existe = repositorioSalon.existeCurso(salon.getCurso());
        if(!existe){
            throw new ExcepcionValorNoEncontrado(EL_CURSO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
    private void validarExistenciaPreviaAlumno(Salon salon){
        boolean existe = repositorioSalon.existeAlumno(salon.getAlumno());
        if(!existe){
            throw new ExcepcionValorNoEncontrado(EL_ALUMNO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
    private void validarCantidadAlumno(Salon salon){
        Integer contadorAlumno = repositorioSalon.obtenerCantidadAlumnos(salon.getCurso());
        if (contadorAlumno > CANTIDAD_MAXIMA_ALUMNO){
            throw new ExcepcionDuplicidad(CANTIDAD_MAXIMA_DE_ALUMNOS_PARA_UN_CURSO_ALCANZADA);
        }
    }
    private void validarHorasAlumno(Salon salon){
        Integer contadorHorasAlumno = repositorioSalon.contadorHorasAlumno(salon.getAlumno());
        Integer horasCursoNuevo = repositorioSalon.obtenerHorasCurso(salon.getCurso());
        horasCursoNuevo = (contadorHorasAlumno == null)? horasCursoNuevo: (contadorHorasAlumno+horasCursoNuevo);
        if(horasCursoNuevo > HORAS_MAXIMAS_ALUMNO){
            throw new ExcepcionValorInvalido(NO_SE_PERMITE_PORQUE_EXCEDE_EL_MAXIMO_DE_HORAS_PERMITIDAS);
        }
    }
}
