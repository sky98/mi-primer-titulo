package com.ceiba.clase.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.puerto.repositorio.RepositorioClase;
import com.ceiba.clase.servicio.testdatabuilder.ClaseTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorNoEncontrado;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearClaseTest {
    private static Clase clase;
    private static RepositorioClase repositorioClase;
    private static ServicioCrearClase servicioCrearClase;

    @BeforeAll
    public static void iniciandoObjetos(){
        clase = new ClaseTestDataBuilder().conId(1L).build();
        repositorioClase = Mockito.mock(RepositorioClase.class);
    }
    @Test
    @DisplayName("Debería crear correctamente en el repositorio")
    void deberiaCrearCorrectamenteEnElRepositorio() {
        // arrange
        Mockito.when(repositorioClase.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioClase.existeAsignacionCurso(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioClase.existeCurso(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioClase.validaHorasInscritasDocente(Mockito.anyLong())).thenReturn(12);
        Mockito.when(repositorioClase.obtenerHorasCurso(Mockito.anyLong())).thenReturn(2);
        servicioCrearClase = new ServicioCrearClase(repositorioClase);
        // act
        servicioCrearClase.ejecutar(clase);
        // assert
        Mockito.verify(repositorioClase,Mockito.times(1)).crear(clase);
    }
    @Test
    @DisplayName("Debería lanzar una excepción cuando se valide la existencia de la clase")
    void deberiaLanzarUnaExcepcionCuandoSeValideLaExistenciaDeLaClase() {
        // arrange
        Mockito.when(repositorioClase.existePorId(Mockito.anyLong())).thenReturn(true);
        servicioCrearClase = new ServicioCrearClase(repositorioClase);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearClase.ejecutar(clase), ExcepcionDuplicidad.class,"La clase ya esta registrada en el sistema");
    }
    @Test
    @DisplayName("Debería lanzar una excepción cuando se valide la asignación del curso")
    void deberiaLanzarUnaExcepcionCuandoSeValideLaAsignacionDelCurso() {
        // arrange
        Mockito.when(repositorioClase.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioClase.existeAsignacionCurso(Mockito.anyLong())).thenReturn(true);
        servicioCrearClase = new ServicioCrearClase(repositorioClase);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearClase.ejecutar(clase), ExcepcionValorNoEncontrado.class,"El curso ya esta asignado a una clase");
    }
    @Test
    @DisplayName("Debería lanzar una excepción cuando se valide la existencia del curso")
    void deberiaLanzarUnaExcepcionCuandoSeValideLaExistenciaDelCurso() {
        // arrange
        Mockito.when(repositorioClase.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioClase.existeAsignacionCurso(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioClase.existeCurso(Mockito.anyLong())).thenReturn(false);
        servicioCrearClase = new ServicioCrearClase(repositorioClase);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearClase.ejecutar(clase), ExcepcionValorNoEncontrado.class,"El curso no existe en el sistema");
    }
    @Test
    @DisplayName("Debería lanzar una excepción cuando se valide el máximo de horas para el docente")
    void deberiaLanzarUnaExcepcionCuandoSeValidaHorasMaximasDeUnDocente() {
        // arrange
        Mockito.when(repositorioClase.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioClase.existeAsignacionCurso(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioClase.existeCurso(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioClase.validaHorasInscritasDocente(Mockito.anyLong())).thenReturn(14);
        Mockito.when(repositorioClase.obtenerHorasCurso(Mockito.anyLong())).thenReturn(2);
        servicioCrearClase = new ServicioCrearClase(repositorioClase);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearClase.ejecutar(clase), ExcepcionValorInvalido.class,"El docente no puede superar el limite de horas máximas");
    }
}