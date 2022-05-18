package com.ceiba.curso.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.curso.modelo.entidad.Curso;
import com.ceiba.curso.puerto.repositorio.RepositorioCurso;
import com.ceiba.curso.servicio.testdatabuilder.CursoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearCursoTest {

    private static Curso curso;
    private static RepositorioCurso repositorioCurso;
    private static ServicioCrearCurso servicioCrearCurso;

    @BeforeAll
    public static void iniciandoObjetos(){
        curso = new CursoTestDataBuilder().conId(1L).build();
        repositorioCurso = Mockito.mock(RepositorioCurso.class);
    }

    @Test
    @DisplayName("Debería crear el curso llamando al repositorio")
    void deberiaCrearElCursoLlamandoAlRepositorio() {
        // arrange
        Mockito.when(repositorioCurso.existePorIdentificacion(Mockito.anyString())).thenReturn(false);
        servicioCrearCurso = new ServicioCrearCurso(repositorioCurso);
        // act
        servicioCrearCurso.ejecutar(curso);
        // assert
        Mockito.verify(repositorioCurso, Mockito.times(1)).crear(curso);
    }

    @Test
    @DisplayName("Debería lanzar una excepción cuando se valide la existencia del Curso")
    void deberiaLanzarUnaExcepcionCuandoSeValideLaExistenciaDelCurso() {
        // arrange
        Mockito.when(repositorioCurso.existePorIdentificacion(Mockito.anyString())).thenReturn(true);
        servicioCrearCurso = new ServicioCrearCurso(repositorioCurso);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCurso.ejecutar(curso), ExcepcionDuplicidad.class,"El curso ya existe en el sistema");
    }
}
