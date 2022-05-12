package com.ceiba.alumno.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.alumno.modelo.entidad.Alumno;
import com.ceiba.alumno.puerto.repositorio.RepositorioAlumno;
import com.ceiba.alumno.servicio.testdatabuilder.AlumnoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarAlumnoTest {

    private static Alumno alumno;
    private static RepositorioAlumno repositorioAlumno;

    @BeforeAll
    public static void iniciandoObjetos(){
        alumno = new AlumnoTestDataBuilder().conId(1L).build();
        repositorioAlumno = Mockito.mock(RepositorioAlumno.class);
    }

    @Test
    @DisplayName("Deberia validar la existencia previa del alumno")
    void deberiaValidarLaExistenciaPreviaDelAlumno() {
        // arrange
        Mockito.when(repositorioAlumno.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarAlumno servicioActualizarAlumno = new ServicioActualizarAlumno(repositorioAlumno);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarAlumno.ejecutar(alumno), ExcepcionDuplicidad.class,"El alumno no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Mockito.when(repositorioAlumno.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarAlumno servicioActualizarAlumno = new ServicioActualizarAlumno(repositorioAlumno);
        // act
        servicioActualizarAlumno.ejecutar(alumno);
        //assert
        Mockito.verify(repositorioAlumno,Mockito.times(1)).actualizar(alumno);
    }
}
