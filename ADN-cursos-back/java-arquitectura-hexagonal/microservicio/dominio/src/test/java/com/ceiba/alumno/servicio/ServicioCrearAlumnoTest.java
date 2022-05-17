package com.ceiba.alumno.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.alumno.modelo.entidad.Alumno;
import com.ceiba.alumno.puerto.repositorio.RepositorioAlumno;
import com.ceiba.alumno.servicio.testdatabuilder.AlumnoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearAlumnoTest {
    @Test
    @DisplayName("Debería lanzar una excepción cuando se valide la existencia del alumno")
    void deberiaLanzarUnaExcepcionCuandoSeValideLaExistenciaDelAlumno() {
        // arrange
        Alumno alumno = new AlumnoTestDataBuilder().build();
        RepositorioAlumno repositorioAlumno = Mockito.mock(RepositorioAlumno.class);
        Mockito.when(repositorioAlumno.existePorIdentificacion(Mockito.anyString())).thenReturn(true);
        ServicioCrearAlumno servicioCrearAlumno = new ServicioCrearAlumno(repositorioAlumno);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearAlumno.ejecutar(alumno), ExcepcionDuplicidad.class,"El alumno ya existe en el sistema");
    }
}
