package com.ceiba.alumno.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.alumno.modelo.entidad.Alumno;
import com.ceiba.alumno.puerto.repositorio.RepositorioAlumno;
import com.ceiba.alumno.servicio.testdatabuilder.AlumnoTestDataBuilder;
import com.ceiba.docente.modelo.entidad.Docente;
import com.ceiba.docente.puerto.repositorio.RepositorioDocente;
import com.ceiba.docente.servicio.ServicioCrearDocente;
import com.ceiba.docente.servicio.testdatabuilder.DocenteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearCursoTest {

    @Test
    @DisplayName("Deberia lanzar una exepecion cuando la longitud de la identificación sea menor a 4")
    void deberiaLanzarUnaExepcionCuandoLaLongitudDeLaIdentificacionSeaMenorACuatro() {
        // arrange
        AlumnoTestDataBuilder alumnoTestDataBuilder = new AlumnoTestDataBuilder().conIdentificacion("124");
        // act - assert
        BasePrueba.assertThrows(alumnoTestDataBuilder::build, ExcepcionLongitudValor.class, "La identificación debe tener una longitud mayor o igual a 4");
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del alumno")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelAlumno() {
        // arrange
        Alumno alumno = new AlumnoTestDataBuilder().build();
        RepositorioAlumno repositorioAlumno = Mockito.mock(RepositorioAlumno.class);
        Mockito.when(repositorioAlumno.existePorIdentificacion(Mockito.anyString())).thenReturn(true);
        ServicioCrearAlumno servicioCrearAlumno = new ServicioCrearAlumno(repositorioAlumno);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearAlumno.ejecutar(alumno), ExcepcionDuplicidad.class,"El alumno ya existe en el sistema");
    }
}
