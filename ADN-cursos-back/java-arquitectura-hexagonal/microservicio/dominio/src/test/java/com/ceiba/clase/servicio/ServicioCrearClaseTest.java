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
    @BeforeAll
    public static void iniciandoObjetos(){
        clase = new ClaseTestDataBuilder().conId(1L).build();
        repositorioClase = Mockito.mock(RepositorioClase.class);
    }

    @Test
    @DisplayName("Debería lanzar una excepción cuando se valide la existencia de la clase")
    void deberiaLanzarUnaExcepcionCuandoSeValideLaExistenciaDeLaClase() {
        // arrange
        Mockito.when(repositorioClase.existeDocenteCurso(Mockito.anyLong(), Mockito.anyLong())).thenReturn(true);
        ServicioCrearClase servicioCrearClase = new ServicioCrearClase(repositorioClase);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearClase.ejecutar(clase), ExcepcionDuplicidad.class,"El docente ya se encuentra inscrito a ese curso");
    }
    @Test
    @DisplayName("Debería lanzar una excepción cuando se valide la existencia del docente")
    void deberiaLanzarUnaExcepcionCuandoSeValideLaExistenciaDelDocente() {
        // arrange
        Mockito.when(repositorioClase.existeDocente(Mockito.anyLong())).thenReturn(false);
        ServicioCrearClase servicioCrearClase = new ServicioCrearClase(repositorioClase);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearClase.ejecutar(clase), ExcepcionValorNoEncontrado.class,"El docente no existe en el sistema");
    }
    @Test
    @DisplayName("Debería lanzar una excepción cuando se valide la existencia del curso")
    void deberiaLanzarUnaExcepcionCuandoSeValideLaExistenciaDelCurso() {
        // arrange
        Mockito.when(repositorioClase.existeDocente(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioClase.existeCurso(Mockito.anyLong())).thenReturn(false);
        ServicioCrearClase servicioCrearClase = new ServicioCrearClase(repositorioClase);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearClase.ejecutar(clase), ExcepcionValorNoEncontrado.class,"El curso no existe en el sistema");
    }
    @Test
    @DisplayName("Debería lanzar una excepción cuando se valide el máximo de horas para el docente")
    void deberiaLanzarUnaExcepcionCuandoSeValidaHorasMaximasDeUnDocente() {
        // arrange
        Mockito.when(repositorioClase.existeDocente(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioClase.existeCurso(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioClase.validaHorasInscritasDocente(Mockito.anyLong())).thenReturn(14);
        Mockito.when(repositorioClase.obtenerHorasCurso(Mockito.anyLong())).thenReturn(2);
        ServicioCrearClase servicioCrearClase = new ServicioCrearClase(repositorioClase);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearClase.ejecutar(clase), ExcepcionValorInvalido.class,"El docente no puede superar el limite de horas máximas");
    }
}