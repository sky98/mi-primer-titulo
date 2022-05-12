package com.ceiba.curso.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.curso.modelo.entidad.Curso;
import com.ceiba.curso.puerto.repositorio.RepositorioCurso;
import com.ceiba.curso.servicio.testdatabuilder.CursoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearCursoTest {

    @Test
    @DisplayName("Debería lanzar una excepción cuando las horas del curso es menor a 1")
    void deberiaLanzarUnaExcepcionCuandoLasHorasSeanMenorAUno() {
        // arrange
        CursoTestDataBuilder cursoTestDataBuilder = new CursoTestDataBuilder().conHoras(1/2);
        // act - assert
        BasePrueba.assertThrows(cursoTestDataBuilder::build, ExcepcionValorInvalido.class, "El valor mínimo de horas es 1");
    }

    @Test
    @DisplayName("Debería lanzar una excepción cuando las horas del curso es mayor a 4")
    void deberiaLanzarUnaExcepcionCuandoLasHorasSeanMayorACuatro() {
        // arrange
        CursoTestDataBuilder cursoTestDataBuilder = new CursoTestDataBuilder().conHoras(5);
        // act - assert
        BasePrueba.assertThrows(cursoTestDataBuilder::build, ExcepcionValorInvalido.class, "El valor máximo de horas es 4");
    }

    @Test
    @DisplayName("Debería lanzar una excepción cuando se valide la existencia del Curso")
    void deberiaLanzarUnaExcepcionCuandoSeValideLaExistenciaDelCurso() {
        // arrange
        Curso curso = new CursoTestDataBuilder().build();
        RepositorioCurso repositorioCurso = Mockito.mock(RepositorioCurso.class);
        Mockito.when(repositorioCurso.existePorIdentificacion(Mockito.anyString())).thenReturn(true);
        ServicioCrearCurso servicioCrearCurso = new ServicioCrearCurso(repositorioCurso);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCurso.ejecutar(curso), ExcepcionDuplicidad.class,"El curso ya existe en el sistema");
    }
}
