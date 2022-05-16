package com.ceiba.salon.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorNoEncontrado;
import com.ceiba.salon.modelo.entidad.Salon;
import com.ceiba.salon.puerto.repositorio.RepositorioSalon;
import com.ceiba.salon.servicio.testdatabuilder.SalonTestDataBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearSalonTest {

    private static Salon salon;
    private static RepositorioSalon repositorioSalon;
    private static ServicioCrearSalon servicioCrearSalon;

    @BeforeAll
    public static void iniciandoObjetos(){
        salon = new SalonTestDataBuilder().build();
        repositorioSalon = Mockito.mock(RepositorioSalon.class);
    }

    @Test
    @DisplayName("Debería lanzar una excepción cuando el salon ya existe en el sistema")
    void deberiaLanzarUnaExcepcionCuandoSeValideLaExistenciaDelSalon() {
        // arrange
        Mockito.when(repositorioSalon.existePorId(Mockito.anyLong())).thenReturn(true);
        servicioCrearSalon = new ServicioCrearSalon(repositorioSalon);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearSalon.ejecutar(salon), ExcepcionDuplicidad.class,"Registro ya se encuentra en el sistema");
    }
    @Test
    @DisplayName("Debería lanzar una excepción validando la existencia del curso")
    void deberiaLanzarUnaExcepcionValidandoLaExistenciaDelCurso() {
        // arrange
        Mockito.when(repositorioSalon.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioSalon.existeCurso(Mockito.anyLong())).thenReturn(false);
        servicioCrearSalon = new ServicioCrearSalon(repositorioSalon);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearSalon.ejecutar(salon), ExcepcionValorNoEncontrado.class,"El curso no existe en el sistema");
    }
    @Test
    @DisplayName("Debería lanzar una excepción cuando la cantidad de alumnos se excede")
    void deberiaLanzarUnaExcepcionCuandoLaCantidadDeAlumnosSeExcede() {
        // arrange
        Mockito.when(repositorioSalon.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioSalon.existeCurso(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioSalon.obtenerCantidadAlumnos(Mockito.anyLong())).thenReturn(26);
        servicioCrearSalon = new ServicioCrearSalon(repositorioSalon);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearSalon.ejecutar(salon), ExcepcionDuplicidad.class,"Cantidad maxima de alumnos para un curso alcanzada");
    }
    @Test
    @DisplayName("Debería lanzar una excepción cuando las horas del alumno exceden las permitidas")
    void deberiaLanzarUnaExcepcionCuandoLasHorasDelAlumnoExcedenLasPermitidas() {
        // arrange
        Mockito.when(repositorioSalon.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioSalon.existeCurso(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioSalon.obtenerCantidadAlumnos(Mockito.anyLong())).thenReturn(25);
        Mockito.when(repositorioSalon.contadorHorasAlumno(Mockito.anyLong())).thenReturn(30);
        Mockito.when(repositorioSalon.obtenerHorasCurso(Mockito.anyLong())).thenReturn(2);
        servicioCrearSalon = new ServicioCrearSalon(repositorioSalon);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearSalon.ejecutar(salon), ExcepcionValorInvalido.class,"No se permite, porque excede el máximo de horas permitidas");
    }

    @Test
    @DisplayName("Debería crear correctamente en el repositorio")
    void deberiaCrearCorrectamenteEnElRepositorio() {
        // arrange
        Mockito.when(repositorioSalon.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioSalon.existeCurso(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioSalon.obtenerCantidadAlumnos(Mockito.anyLong())).thenReturn(25);
        Mockito.when(repositorioSalon.contadorHorasAlumno(Mockito.anyLong())).thenReturn(28);
        Mockito.when(repositorioSalon.obtenerHorasCurso(Mockito.anyLong())).thenReturn(2);
        servicioCrearSalon = new ServicioCrearSalon(repositorioSalon);
        // act
        servicioCrearSalon.ejecutar(salon);
        //assert
        Mockito.verify(repositorioSalon,Mockito.times(1)).crear(salon);
    }
}
